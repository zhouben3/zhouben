package com.zb.spider9002.util;

import java.text.ParseException;
import java.util.HashMap;

import static com.zb.spider9002.util.DateUtil.getDate;

public class JobRequestUtil {
    public static RequestBean turn(String request) throws ParseException {
        RequestBean requestBean = new RequestBean();
        //System.out.println(request);
        int x = request.indexOf("招");
        if (x > 0) {
            char a = request.charAt(x + 1);
            if (a > '0' && a <= '9') {
                int n = Integer.parseInt(String.valueOf(request.charAt(x + 1)));
                requestBean.setNeednum(n);
            }
            //System.out.println(n);
        }
        int y = request.indexOf("发布");
        if (y > 0) {
            String temp = request.substring(y - 5, y);
            requestBean.setDate(getDate(temp));
            //System.out.println(temp);
        }
        //request.replaceAll("    "," ");
        String str[] = request.split("    ");
        //System.out.println(str.length);
        String exp = str[1];
        System.out.println(exp);
        int k = exp.indexOf("年");
        if (exp.indexOf("无") >=0) {
            requestBean.setExp(1);
        } else if (k > 0) {
            int l = exp.indexOf("-");
            if (l > 0) {
                int first = Integer.parseInt(String.valueOf(exp.charAt(l - 1)));
                int last = Integer.parseInt(String.valueOf(exp.charAt(l + 1)));
                if (first >= 1 && last < 3) {
                    requestBean.setExp(2);
                } else if (first >= 3 && last < 5) {
                    requestBean.setExp(3);
                } else if (first >= 5 && last < 10) {
                    requestBean.setExp(4);
                } else {
                    requestBean.setExp(5);
                }
            }else{
                requestBean.setExp(2);
            }
        }
        String edu = str[2];
        //System.out.println(edu);
        HashMap map = new HashMap();
        map.put("初中以下", 1);
        map.put("初中", 1);
        map.put("高中", 2);
        map.put("中技", 2);
        map.put("中专", 2);
        map.put("大专", 3);
        map.put("本科", 4);
        map.put("硕士", 5);
        map.put("博士", 6);
        Integer m = (Integer) map.get(edu);

        if (m != null) {
            requestBean.setEducation(m);
            //System.out.println(m);
        } else {
            requestBean.setEducation(0);
        }
        //System.out.println(m);
        //System.out.println(edu);
        //System.out.println(exp);
        return requestBean;
    }

    public static void main(String[] args) {
        String edu = "本科";
        HashMap map = new HashMap();
        map.put("初中以下", 1);
        map.put("初中", 1);
        map.put("高中", 2);
        map.put("中技", 2);
        map.put("中专", 2);
        map.put("大专", 3);
        map.put("本科", 4);
        map.put("硕士", 5);
        map.put("博士", 6);
        Integer m = (Integer) map.get(edu);
        System.out.println(m);
    }
}
