package com.david.test;

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

        String tcpStr = "AT+CWSAP_DEF=" + "\"DALIGE\"" + "," + "\"12345678\"" + "," + "11,4";

        // 转义字符串两边含有双引号
        String str1 = "\"david\"";
        System.out.println("转义字符串两边含有双引号：" + str1);
        // 字符串中间含有双引号
        String str2 = "david\"is\"java";
        System.out.println("字符串中间含有双引号：" + str2);
        // 使用转义字符还可以使字符串包含其他字符
        String str3 = "\\david";
        System.out.println("使用转义字符还可以使字符串包含其他字符：" + str3);
        // 变量使用双引号包括
        String userName = "david";
        userName = "java";
        String str4 = '\"' + userName + '\"';
        System.out.println("变量使用双引号包括:" + str4);
        System.out.println(tcpStr);
    }
}