package com.david.test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author David
 * @date 2020/3/25
 * @time 16:41
 */
public class StringTest {
    public static void main(String[] args) {
//        String[] arrays = "1。2".split("。");
//        String[] arrays = "1.2".split("\\.");
//        System.out.println(arrays.length);
//
//        String  a = "12间";
//        System.out.println(a.substring(0,a.length()-1));
//
//        String tcpStr = "AT+CWSAP_DEF=" + "\"DALIGE\"" + "," + "\"12345678\"" + "," + "11,4";
//
//        // 转义字符串两边含有双引号
//        String str1 = "\"david\"";
//        System.out.println("转义字符串两边含有双引号：" + str1);
//        // 字符串中间含有双引号
//        String str2 = "david\"is\"java";
//        System.out.println("字符串中间含有双引号：" + str2);
//        // 使用转义字符还可以使字符串包含其他字符
//        String str3 = "\\david";
//        System.out.println("使用转义字符还可以使字符串包含其他字符：" + str3);
//        // 变量使用双引号包括
//        String userName = "david";
//        userName = "java";
//        String str4 = '\"' + userName + '\"';
//        System.out.println("变量使用双引号包括:" + str4);
//        System.out.println(tcpStr);
//
//
//        String time = "2021-01-01T08:41:00";
//        String[] t = time.split("T");
//        String s = t[0] +" "+ t[1];
//        System.out.println(s);

//        String admissionDate = "2021-03-25 09:09:00";
//
//        DateTime time = DateUtil.parseDateTime(admissionDate);
//        time.getTime();
//        System.out.println("time = "+ time.getTime());
//
//        String today = DateUtil.today();
//        System.out.println(today);
//
//        String year = admissionDate.substring(0,4);
//        String month = admissionDate.substring(4,6);
//        String day =admissionDate.substring(6,8);
//        admissionDate = year+"-"+month+"-"+day;
//        if (admissionDate.equals(today)){
//            System.out.println(true);
//        }else {
//            System.out.println(false);
//        }
//
//        System.out.println("---------------");
////        System.out.println(com.david.utils.DateUtil.isAfterDay(System.currentTimeMillis(), time.getTime()));
//        System.out.println(DateUtil.isSameDay(new Date(),time));
//
//        String age = "1000岁";
//        int sui = age.indexOf("岁");
//        System.out.println(sui);
//
//        System.out.println(age.substring(0,sui+1));
//
//
//        String name = "zhangsan12";
//        System.out.println(name.substring(0,name.length()-2));
//
//
//
//        String bedCode = "12+34";
//        System.out.println(bedCode.replaceAll("[a-zA-Z]", ""));
//
//        int count = 1000;
//        int all  = 900;
//        System.out.println(all/count);


        Integer age = Integer.valueOf("80");
        if (age >= 65) {
            System.out.println("age > 80");
        }
    }
}