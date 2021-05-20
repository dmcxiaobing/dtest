package com.david.jdk8;

public class Test {
    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            public void run() {
//
//            }
//        });

        new Thread(() -> System.out.println("hello lambda")).start();


    }
}
