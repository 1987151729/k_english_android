package com.k.initial.english.mvp.model.entity;

import java.util.Date;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 22/05/2018
 * Time: 08:13
 */
public class UserEntity {

    private long no;
    private String userID;
    private String name;
    private int sex;
    private String avatar;
    private int age;
    private String constellation;
    private Date birth;
    private String city;

    public UserEntity(
            long no,
            String userID,
            String name,
            int sex,
            String avatar,
            int age,
            String city
    ) {
        this.no = no;
        this.userID = userID;
        this.name = name;
        this.sex = sex;
        this.avatar = avatar;
        this.age = age;
        this.city = city;
    }

    public UserEntity(
            long no,
            String userID,
            String name,
            int sex,
            String avatar,
            int age,
            Date birth,
            String city
    ) {
        this.no = no;
        this.userID = userID;
        this.name = name;
        this.sex = sex;
        this.avatar = avatar;
        this.age = age;
        this.birth = birth;
        this.city = city;
    }

    public UserEntity(
            long no,
            String userID,
            String name,
            int sex,
            String avatar,
            int age,
            String constellation,
            Date birth,
            String city
    ) {
        this.no = no;
        this.userID = userID;
        this.name = name;
        this.sex = sex;
        this.avatar = avatar;
        this.age = age;
        this.constellation = constellation;
        this.birth = birth;
        this.city = city;
    }

    // 获取属性值

    public long getNO() {
        return this.no;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getName() {
        return this.name;
    }

    public int getSex() {
        return this.sex;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int getAge() {
        return this.age;
    }

    public String getConstellation() {
        return this.constellation;
    }

    public Date getBirth() {
        return this.birth;
    }

    public String getCity() {
        return this.city;
    }

    // 设置属性值

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
