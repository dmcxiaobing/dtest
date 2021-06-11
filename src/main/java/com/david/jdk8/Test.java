package com.david.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            public void run() {
//
//            }
//        });

        new Thread(() -> System.out.println("hello lambda")).start();


        Consumer<String> consumer = s -> System.out.println(s);

        // 传参
        testConsumer(s -> System.out.println(s), "test Consumer");

        List<String> list = new ArrayList<>();
        list.add("david");
        list.add("mcxiaobing");
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {

                return "supplier";
            }
        };

        String st = testSupplier(supplier);
        System.out.println(st);

        String su = testSupplier(() -> "zhangsanSU");
        System.out.println(su);


        String maxLength = testSupplier(() -> {
            String max = list.get(0);
            for (String str : list) {
                if (max.length() < str.length()) {
                    max = str;
                }
            }
            return max;
        });
        System.out.println(maxLength);


        boolean state = testPredicate(str -> {
            if (str.length() > 1) {
                return true;
            }
            return false;
        }, "zhangsan");
        System.out.println(state);
    }


    // 消费
    public static void testConsumer(Consumer<String> consumer, String s) {
        consumer.accept(s);
    }

    // 供给
    public static String testSupplier(Supplier<String> supplier) {
        return supplier.get();
    }

    public static boolean testPredicate(Predicate<String> predicate, String str) {
        return predicate.test(str);
    }

    public static String testFunction(Function<String,String> function, String str) {
        return function.apply(str);
    }

//   for (String s : list) {
//        if (s.length() > 6) {
//            return supplier.get();
//
//        }
//    }
//        return "";
}
