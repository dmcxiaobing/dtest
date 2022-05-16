package com.david.jdk8;

import com.david.entity.User;

import java.util.Optional;


/**
 * @author David Zheng
 * @date 2022/05/13
 * <p>
 * Optional不是一个函数式接口，而是一个精巧的工具接口，用来防止NullPointerEception产生
 */
public class Optionals {
    public static void main(String[] args) {

        test1();

    }

    private static void test1() {

        User user = new User();
        user.setName("zhangsan");
        String sex = getSexByOptionals(user);
        System.out.println(sex);

    }

    private static String getSex(User user) {
        if (user.getSex() == null) {
            return "未知";
        }
        return user.getSex();
    }

    private static String getSexByOptionals(User user) {
        String sex = Optional.ofNullable(user).map(o -> o.getSex()).orElse("未知optionals");
        return sex;
    }

}
