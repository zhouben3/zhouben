package com.zb.spider9002.util;

/**
 * zb
 * salary的转换函数，将爬取String工资串转化为double的工资
 */
public class SalaryUtil {
    public static SalaryBean turn(String salary) {
        SalaryBean salaryBean = new SalaryBean();
        if (salary.indexOf("月") > 0) {
            salaryBean.setIsmonth(true);
            int x=salary.indexOf("千");
            int y=salary.indexOf("万");
            String temp =new String();
            if(x>0) {
                temp=salary.substring(0,x);
                if(temp!=null){
                    String[] sal=temp.split("-");
                    salaryBean.setMin(Double.parseDouble(sal[0])*1000);
                    salaryBean.setMax(Double.parseDouble(sal[1])*1000);
                }
            }
            else if(y>0){
                temp=salary.substring(0,y);
                if(temp!=null){
                    String[] sal=temp.split("-");
                    salaryBean.setMin(Double.parseDouble(sal[0])*10000);
                    salaryBean.setMax(Double.parseDouble(sal[1])*10000);
                }
            }

        } else if (salary.indexOf("天") > 0) {
            salaryBean.setIsmonth(false);
            int x=salary.indexOf("元");
            int y=salary.indexOf("-");
            String temp=new String();
            if(y>0){
                if(x>0){
                    temp=salary.substring(0,x);
                    if(temp!=null){
                        String[] sal=temp.split("-");
                        salaryBean.setMin(Double.parseDouble(sal[0]));
                        salaryBean.setMax(Double.parseDouble(sal[1]));
                    }
                }
            }else{
                temp=salary.substring(0,x);
                if(temp!=null){
                    salaryBean.setMin(Double.parseDouble(temp));
                }
            }
        }
        return salaryBean;
    }
    public static void main(String[] args){
//        String test="160元/天";
//        SalaryBean salaryBean=turn(test);
//        System.out.println(salaryBean.getMax());
//        System.out.println(salaryBean.getMin());
        System.out.println("//&nbsp");
    }
}
