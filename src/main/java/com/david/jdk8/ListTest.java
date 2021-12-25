package com.david.jdk8;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3);
//        List<StudentInfo> boys =
//        studentList.stream().filter(s->s.getGender() && s.getHeight() >= 1.8).collect(Collectors.toList());
        // 过滤掉大于1的数据
        List<Integer> newList = list.stream().filter(o -> o > 1).collect(Collectors.toList());
        for (Integer integer : newList) {
            System.out.println(integer);
        }


        String a = "1x";
        System.out.println(a.substring(1));



    }
}
