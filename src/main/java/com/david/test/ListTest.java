package com.david.test;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        List<String> list2 = Lists.newArrayList();
        System.out.println(CollectionUtil.isEmpty(list));
        System.out.println(CollectionUtil.isNotEmpty(list2));
    }
}
