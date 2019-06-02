package com.zb.spider9002.pipeline;


import com.zb.base.entity.*;
import com.zb.base.mapper.*;
import com.zb.spider9002.model.JobBean;
import com.zb.spider9002.util.JobRequestUtil;
import com.zb.spider9002.util.RequestBean;
import com.zb.spider9002.util.SalaryBean;
import com.zb.spider9002.util.SalaryUtil;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

import static com.zb.spider9002.util.JobRequestUtil.turn;

@Component("JobInfoDaoPipeline")
public class JobInfoDaoPipeline implements PageModelPipeline<JobBean> {

    @Resource
    private PositionEntityMapper positionEntityMapper;
    @Resource
    private PAddressEntityMapper pAddressEntityMapper;
    @Resource
    DBCityEntityMapper dbCityEntityMapper;
    @Resource
    CUrlEntityMapper cUrlEntityMapper;
    @Resource
    CTypeEntityMapper cTypeEntityMapper;
    @Resource
    CGuimoEntityMapper cGuimoEntityMapper;
    @Resource
    CompanyEntityMapper companyEntityMapper;
    @Resource
    CHangyeEntityMapper cHangyeEntityMapper;

    @Override
    public void process(JobBean jobBean, Task task) {
        Integer id = positionEntityMapper.selectByUrl(jobBean.getJoburl());
        if (id == null) {
            //定义需要插入的pojo类
            PositionEntity positionEntity = new PositionEntity();
            PAddressEntity pAddressEntity = new PAddressEntity();
            // String joburl=jobBean.getJoburl();
            //String jobname=jobBean.getJobname();
            // String salary=jobBean.getSalary();
            //System.out.println(salary);
            String joburl = jobBean.getJoburl();
            positionEntity.setpUrl(joburl);
            if (joburl.indexOf("t=04") > 0) {
                positionEntity.setpIsstu(true);
            } else {
                positionEntity.setpIsstu(false);
            }
            positionEntity.setpFrom(1);
            positionEntity.setpName(jobBean.getJobname());
            //对薪水处理，将字符串转化为double
            SalaryBean salaryBean = SalaryUtil.turn(jobBean.getSalary());
            positionEntity.setpMinware(salaryBean.getMin());
            positionEntity.setpIsmonth(salaryBean.isIsmonth());
            positionEntity.setpMaxware(salaryBean.getMax());
            String request = jobBean.getRequest().replaceAll("\\u00A0", " ");
//        for(int i=0;i<request.length();i++){
//            System.out.println(Integer.valueOf(request.charAt(i)));
//        }
            //System.out.println(request);
            //对request内容处理，有城市，所需经验，教育程度等
            String temp[] = request.split("    ");
            //对地址处理
            String address = temp[0];
            int j = address.indexOf("-");
            if (j > 0) {
                //处理职位城市信息
                String city1 = address.substring(0, j).replaceAll(" ", "");
                city1 = '%' + city1 + "市" + '%';
                //System.out.println(city1);
                Integer citynum1 = dbCityEntityMapper.selectByName(city1);
                pAddressEntity.setApCity1(citynum1);
                String city2 = address.substring(j + 1).replaceAll(" ", "");
                city2 = '%' + city2 + '%';
                //这里用list接受是因为**区有多个
                List<Integer> list = dbCityEntityMapper.selectByNameList(city2);
                if (list.size() > 1) {
                    String temp1 = citynum1.toString().substring(0, 3);
                    String temp2 = citynum1.toString().substring(0, 4);
                    Integer citynum2 = 0;
                    for (int i = 0; i < list.size(); i++) {
                        String temp3 = list.get(i).toString();
                        if (temp3.indexOf(temp2) > 0) {
                            citynum2 = list.get(i);
                            pAddressEntity.setApCity2(citynum2);
                        }
                    }
                    if (citynum2 == 0) {
                        for (int i = 0; i < list.size(); i++) {
                            String temp3 = list.get(i).toString();
                            if (temp3.indexOf(temp1) > 0) {
                                citynum2 = list.get(i);
                                pAddressEntity.setApCity2(citynum2);
                            }
                        }
                    }
                } else {
                    if (list.size() == 0) pAddressEntity.setApCity2(0);
                        //这里有错
                    else pAddressEntity.setApCity2(list.get(0));
                    //System.out.println(city2);
                }
            } else {
                String city3 = address.replaceAll(" ", "");
                city3 = '%' + city3 + "市" + '%';
                pAddressEntity.setApCity1(dbCityEntityMapper.selectByName(city3));

            }
            //System.out.println(pAddressEntity.getApCity2());
            // String exp=temp[1];
            //exp='%'+exp+'%';
            //System.out.println(pExperienceEntityMapper.selectByExpName(exp));
//        System.out.println(temp.length);
//        for(int i=0;i<temp.length;i++){
//            //System.out.println(i);
//
//            System.out.println(temp[i]);
//        }

            RequestBean requestBean = new RequestBean();
            try {
                requestBean = turn(request);
                positionEntity.setpCdate(requestBean.getDate());
                positionEntity.setpEdu(requestBean.getEducation());
                positionEntity.setpExp(requestBean.getExp());
                positionEntity.setpNeednum(requestBean.getNeednum());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String welfare = jobBean.getWelfare();
            positionEntity.setpInfo(welfare + jobBean.getJobmessage());
            //Integer c = cUrlEntityMapper.selectByUrl(jobBean.getCompanyurl());
            Integer c = companyEntityMapper.selectByName(jobBean.getCname());
            if (c != null) {
                positionEntity.setpCid(c);
                positionEntityMapper.insert(positionEntity);
                int pid = positionEntityMapper.selectByUrl(positionEntity.getpUrl());
                pAddressEntity.setApPid(pid);
                pAddressEntityMapper.insert(pAddressEntity);
            } else {
//                System.out.println(jobBean.getComcontent());
//                System.out.println(jobBean.getCominfo());
//                System.out.println(jobBean.getClocation());
//                System.out.println(jobBean.getComaddress());
                CompanyEntity companyEntity = new CompanyEntity();
                CUrlEntity cUrlEntity = new CUrlEntity();
                String comContent = jobBean.getComcontent().replaceAll("\\u00A0", "");
//                for(int i=0;i<comContent.length();i++){
//                    System.out.println(Integer.valueOf(comContent.charAt(i)));
//                }
//                System.out.println(comContent);
                String str[] = comContent.split("\\|");
                companyEntity.setcType(cTypeEntityMapper.selectByName(str[0]));
                companyEntity.setcGuimo(cGuimoEntityMapper.selectByName(str[1]));
                String hangye = str[2];
                if (hangye.indexOf(" ") > 0) {
                    String hangyelist[] = hangye.split(" ");
                    companyEntity.setcHangye1(cHangyeEntityMapper.selectByName(hangyelist[0]));
                    companyEntity.setcHangye2(cHangyeEntityMapper.selectByName(hangyelist[1]));
                } else {
                    companyEntity.setcHangye1(cHangyeEntityMapper.selectByName(hangye));
                }
                companyEntity.setcName(jobBean.getCname());
                companyEntity.setcInfo(jobBean.getCominfo());
                companyEntity.setcAddress(jobBean.getComaddress());
                companyEntityMapper.insert(companyEntity);
                Integer cid = companyEntityMapper.selectByName(companyEntity.getcName());
                //companyEntity
                cUrlEntity.setUrlId(cid);
                cUrlEntity.setUrlFrom(1);
                cUrlEntity.setUrlUrl(jobBean.getCompanyurl());
                cUrlEntityMapper.insert(cUrlEntity);


                positionEntity.setpCid(cid);
                positionEntityMapper.insert(positionEntity);
                int pid = positionEntityMapper.selectByUrl(positionEntity.getpUrl());
                pAddressEntity.setApPid(pid);
                pAddressEntityMapper.insert(pAddressEntity);


            }
            //String cname=jobBean.getCname();
//            String clocation=jobBean.getClocation();
//            String companyurl=jobBean.getCompanyurl();
//            String comcontent=jobBean.getComcontent();
//            String cominfo=jobBean.getCominfo();
//            String comaddress=jobBean.getComaddress();
//            String jobmessage=jobBean.getJobmessage();
            //System.out.println("joburl"+joburl+"     /n"+jobname+"     /n"+request+"     /n"+salary+"     /n"+welfare);
            //System.out.println("companyurl"+"     /n"+companyurl+"     /n"+clocation+"     /n"+comaddress+"     /n"+cname+"     /n"+comcontent+"     /n"+cominfo);
            //System.out.println("jobmessage"+jobmessage);
            //String request=jobBean.getRequest();
            //System.out.println("request"+request);
            //PositionEntity positionEntity=new PositionEntity();
//            positionEntity.setPMinware(0.0);
//            positionEntity.setPMinware(10000.0);
            //positionEntity;
            //positionEntityMapper.insert(positionEntity);
        } else {
            return;
        }

    }
}
