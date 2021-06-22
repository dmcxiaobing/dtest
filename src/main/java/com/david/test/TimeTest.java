package com.david.test;


import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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
    public void MillisToDate() throws ParseException {
        Long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat t_dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = t_dateFormat.format(date);
        System.out.println(format);
        Date date1 = t_dateFormat.parse(format);
        System.out.println(date1);
    }


}
