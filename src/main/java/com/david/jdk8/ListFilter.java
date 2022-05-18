package com.david.jdk8;

import com.david.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author David Zheng
 * @date 2022/05/18
 * @email dmcxiaobing@foxmail.com
 */
public class ListFilter {

    @Test
    public void getMax(){
        User user = new User();
        user.setAge(11);
        User user1 = new User();
        user1.setAge(22);

        ArrayList<User> userArrayList = newArrayList(user);
        userArrayList.add(user1);
        // 取出年龄最大的
        // 现将对象list转成带有age的int泛型list
        Integer max = Collections.max(userArrayList.stream().map(User::getAge).collect(Collectors.toList()));
        System.out.println(max);

        // 取出年龄最小的
        System.out.println(Collections.min(userArrayList.stream().map(User::getAge).collect(Collectors.toList())));

        // 取出年龄大于10的数据
        System.out.println("-----");


        // 取出age大于10的年龄，根据对象集合转为age集合，然后再利用过滤取出大于10的list
        List<Integer> list = userArrayList.stream().map(User::getAge).collect(Collectors.toList()).stream().filter(o -> o > 0).collect(Collectors.toList());
        list.stream().forEach(o-> System.out.println(o));

        System.out.println("----");
        // 直接根据对象集合的属性过滤出age大于15的数据
        List<User> users = userArrayList.stream().filter(o -> o.getAge() > 15).collect(Collectors.toList());
        users.stream().forEach(o-> System.out.println(o.getAge()));
    }

    @Test
    public void getMaxOptional(){
        User user = new User();
        user.setName("david");
        User user1 = new User();
        ArrayList<User> userArrayList = newArrayList(user);
        userArrayList.add(user1);
        // 取出名字最长的。这里故意搞出一个空指针.
//        String max = Collections.max(userArrayList.stream().map(User::getName).collect(Collectors.toList()));
//        System.out.println(max);

        // 我们可以用optinnal类防止空指针


    }
}
