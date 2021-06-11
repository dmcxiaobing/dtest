package com.david.test;


import com.david.utils.DateUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author David
 * @date 2019/9/5
 * @time 21:02
 */
public class TimeTest {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void MillisToDate() {


    }

    public  String convert2(String ampm){
        if(ampm.contains("am")){
            ampm=ampm.substring(0,ampm.length()-2);
        }else if(ampm.contains("pm")){
            ampm=ampm.substring(0,ampm.length()-2);
            int hour=Integer.parseInt(ampm.split(":")[0]);
            if(hour<12){
                ampm=(hour+12)+":"+ampm.split(":")[1];
            }
        }
        return ampm;
    }

    public String convert(String ampm) {
        // 在此处写出解决问题的程序代码 …
        if (ampm.contains("am")) {
            return ampm.substring(0, ampm.indexOf("am"));
        } else if (ampm.contains("pm")) {
            int i = ampm.indexOf(":");
            String s = ampm.substring(0, i);
            int hour = Integer.parseInt(s);
            if (hour >= 12) {
                String res = ampm.substring(0, ampm.indexOf("pm"));
                return res;
            } else {
                String sHour = hour + 12 + "";
                return sHour + ampm.substring(ampm.indexOf(":"), ampm.indexOf("pm"));
            }
        } else {
            return ampm;
        }
    }
}
