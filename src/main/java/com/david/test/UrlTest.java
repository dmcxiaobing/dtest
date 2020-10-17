package com.david.test;

import cn.hutool.core.util.StrUtil;

public class UrlTest {

    public static void main(String[] args) {
//        String url = "http://192.168.0.30:84/files/ss/3.pdf";
//        //
//        String[] urls = url.split("/");
//        if (urls != null && urls.length > 0) {
//            String filename = urls[urls.length - 1];
//            System.out.println(filename);
//        }
//
//        String room = "1房";
//        String room2 = StrUtil.format("{}", room);
//        System.out.println(room2);


        System.out.println(clearHttp("HTTP://10.168.1.111"));


    }


    public static String clearHttp(String url) {

        if (url == null || "".equals(url)) {
            return url;
        }

        if (url.contains("http://")) {
            return url.substring(7, url.length());
        }
        if (url.contains("https://")) {
            return url.substring(8, url.length());
        }
        if (url.contains("HTTP://")) {
            return url.substring(7, url.length());
        }
        if (url.contains("HTTPS://")) {
            return url.substring(8, url.length());
        }
        return url;

    }
}
