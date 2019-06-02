package com.zb.spider9002.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date getDate(String Time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       // Date date=new Date();
        //String datestr = format.format(date);
        //String time=datestr.substring(0,4);
        String time="2019";
        time=time+"-"+Time;
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(time);
        //System.out.println(time);
        //Date date1=format.parse(time);
        //System.out.println(date1);
        return date1;
    }
    public static void main(String[] args){
        String temp="05-31";
        try {
            getDate(temp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
