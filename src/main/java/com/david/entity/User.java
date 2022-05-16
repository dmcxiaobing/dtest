package com.david.entity;


import java.io.Serializable;

/**
 * @author David Zheng
 * @date 2022/05/16
 */
public class User implements Serializable {

    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
