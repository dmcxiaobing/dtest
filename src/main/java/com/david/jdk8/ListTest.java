package com.david.jdk8;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author david
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3);
//        List<StudentInfo> boys =
//        studentList.stream().filter(s->s.getGender() && s.getHeight() >= 1.8).collect(Collectors.toList());
        /**
         * 过滤掉大于1的list
         */
        List<Integer> newList = list.stream().filter(o -> o > 1).collect(Collectors.toList());
        for (Integer integer : newList) {
            System.out.println(integer);
        }

        System.out.println("------------");


    }
}
