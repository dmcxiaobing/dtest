package com.david.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author David Zheng
 * @date 2022/05/13
 */
public class ListsSort {
    public static void main(String[] args) {

        /**
         * 排序list
         */
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        names.stream().forEach(o -> System.out.println(o));
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println("------------");
        names.stream().forEach(o -> System.out.println(o));
        System.out.println("------------");
        /**
         * 更简单的方法排序
         */
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        names.stream().forEach(o -> System.out.println(o));
        System.out.println("------------");
        /**
         * 还可以简写
         */
        Collections.sort(names, (String a, String b) -> a.compareTo(b));
        names.stream().forEach(o -> System.out.println(o));
        /**
         * 还可以省略类型
         */
        Collections.sort(names, (a, b) -> b.compareTo(a));

    }
}
