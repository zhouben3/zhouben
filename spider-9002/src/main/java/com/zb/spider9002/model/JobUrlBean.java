package com.zb.spider9002.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.io.IOException;
import java.util.List;

//@HelpUrl("https://jobs.51job.com/*.html\\?.*")
//@TargetUrl("https://joobs.51job.com/*.html/?*")
public class JobUrlBean implements AfterExtractor {
    @ExtractBy(value = "//div[@class='tHeader tHjob']/div[@class='in']/div[@class='cn']/h1/text()", notNull = true)
    String jobname;
    @ExtractByUrl(notNull = true)
    String joburl;
    @ExtractBy(value = "//div[@class='tHeader tHjob']/div[@class='in']/div[@class='cn']/strong/text()")
    String salary;
    @ExtractBy(value = "//div[@class='tHeader tHjob']/div[@class='in']/div[@class='cn']/p[@class='msg ltype']/text()")
    String request;
    @ExtractBy(value = "//div[@class='tHeader tHjob']/div[@class='in']/div[@class='cn']/div[@class='jtag']/div[@class='t1']/span/text()")
    String welfare;
    //   @ExtractBy(value = "//div[@class='tCompany_main']/div[@class='tBorderTop_box']/div[@class='bmsg job_msg inbox']/text()/regex('(?<=<p>).*(?=</p>)')")
//    String test;
    @ExtractBy(value = "//div[@class='tCompany_main']/div[@class='tBorderTop_box']/div[@class='bmsg job_msg inbox']/p/text() | //div[@class='tCompany_main']/div[@class='tBorderTop_box']/div[@class='bmsg job_msg inbox']/div/text()", multi = true)
    List<String> jobmessagelist;
    @ExtractBy(value = "//div[@class='tHeader tHjob']/div[@class='in']/div[@class='cn']/p[@class='cname']/a/text()", notNull = true)
    String cname;
    @ExtractBy(value = "//div[@class='tHeader tHjob']/div[@class='in']/div[@class='cn']/p[@class='cname']/a/@href", notNull = true)
    //@ExtractByUrl(value = "//div[@class='tHeader tHjob']/div[@class='in']/div[@class='cn']/p[@class='cname']/a[@href]",notNull = true)
            String companyurl;
    @ExtractBy(value = "//div[@class='tCompany_main']/div[@class='tBorderTop_box']/div[@class='bmsg inbox']/p[@class='fp']/text()")
    String clocation;

    String jobmessage;
    String comcontent;
    String cominfo;
    String comaddress;

//    public String getTest() {
//        return test;
//    }
//
//    public void setTest(String test) {
//        this.test = test;
//    }

    @Override
    public String toString() {
        return "JobBean{" +
                "jobname='" + jobname + '\'' +
                ", joburl='" + joburl + '\'' +
                ", salary='" + salary + '\'' +
                ", request='" + request + '\'' +
                ", welfare='" + welfare + '\'' +
                ", cname='" + cname + '\'' +
                ", companyurl='" + companyurl + '\'' +
                ", clocation='" + clocation + '\'' +
                ", jobmessage='" + jobmessage + '\'' +
                ", comcontent='" + comcontent + '\'' +
                ", cominfo='" + cominfo + '\'' +
                ", comaddress='" + comaddress + '\'' +
                '}';
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getJoburl() {
        return joburl;
    }

    public void setJoburl(String joburl) {
        this.joburl = joburl;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCompanyurl() {
        return companyurl;
    }

    public void setCompanyurl(String companyurl) {
        this.companyurl = companyurl;
    }

    public String getClocation() {
        return clocation;
    }

    public void setClocation(String clocation) {
        this.clocation = clocation;
    }

    public String getJobmessage() {
        return jobmessage;
    }

    public void setJobmessage(String jobmessage) {
        this.jobmessage = jobmessage;
    }

    public String getComcontent() {
        return comcontent;
    }

    public void setComcontent(String comcontent) {
        this.comcontent = comcontent;
    }

    public String getCominfo() {
        return cominfo;
    }

    public void setCominfo(String cominfo) {
        this.cominfo = cominfo;
    }

    public String getComaddress() {
        return comaddress;
    }

    public void setComaddress(String comaddress) {
        this.comaddress = comaddress;
    }

    @Override
    public void afterProcess(Page page) {
        while (jobmessagelist.size() > 0) {
            //System.out.println(jobmessagelist.size());
            jobmessage += jobmessagelist.get(0);
            jobmessagelist.remove(0);
        }
        if (jobname != null && jobname != " ") {
            if (companyurl != null) {
                try {
                    Document dom = Jsoup.connect(companyurl).get();
                    Element element_comntent = dom.select("p.ltype").first();
                    comcontent = element_comntent.text();
                    Element element_info = dom.select("div.con_txt").first();
                    cominfo = element_info.text();
                    // if(dom.select("p.fp"))
                    //这里抓一下空异常
                    try {
                        Element element_address = dom.select("p.fp").first();
                        comaddress = element_address.text();

                    } catch (NullPointerException e) {
                        comaddress=null;
                        //e.printStackTrace();
                        //System.out.println(comaddress);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
