package com.example.tommorow.entity;

/**
 *用户的实体类
 */

public class User {
    private String name;
    private String childName;
    private String passWord;
    private String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public User() {
    }

    public User(String name, String childName, String passWord, String birthday) {

        this.name = name;
        this.childName = childName;
        this.passWord = passWord;
        this.birthday = birthday;
    }
}
