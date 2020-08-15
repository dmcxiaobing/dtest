package com.david.test;

public class UrlTest {

    public static void main(String[] args) {
        String url = "http://192.168.0.30:84/files/ss/3.pdf";
        //
        String[] urls = url.split("/");
        if (urls!=null && urls.length>0){
          String filename =  urls[urls.length-1];
            System.out.println(filename);
        }
    }
}
