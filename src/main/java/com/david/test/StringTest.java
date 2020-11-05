package com.david.test;

/**
 * @author David
 * @date 2020/3/25
 * @time 16:41
 */
public class StringTest {
    public static void main(String[] args) {
//        String[] arrays = "1。2".split("。");
        String[] arrays = "1.2".split("\\.");
        System.out.println(arrays.length);

        String  a = "12间";
        System.out.println(a.substring(0,a.length()-1));
    }
}