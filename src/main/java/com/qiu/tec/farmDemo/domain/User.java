package com.qiu.tec.farmDemo.domain;

public class User {

    //1.用户名
    private String userName;

    //2.昵称
    private String cuteName;

    //3.年龄
    private String age;

    //4.注册日期
    private String birthDay;

    //5.死亡日期
    private String deathDay;

    //6.虚拟注册日期
    private String virRegistday;

    public User() {
    }

    public User(String userName, String cuteName, String age, String birthDay, String deathDay, String virRegistday) {
        this.userName = userName;
        this.cuteName = cuteName;
        this.age = age;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.virRegistday = virRegistday;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCuteName() {
        return cuteName;
    }

    public void setCuteName(String cuteName) {
        this.cuteName = cuteName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(String deathDay) {
        this.deathDay = deathDay;
    }

    public String getVirRegistday() {
        return virRegistday;
    }

    public void setVirRegistday(String virRegistday) {
        this.virRegistday = virRegistday;
    }
}
