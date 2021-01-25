package com.qiu.tec.farmDemo.domain;

public class Timer {

    //北京时间
    private String bjTime;

    //系统虚拟时间
    private String virTime;

    public Timer() {
    }

    public String getBjTime() {
        return bjTime;
    }

    public void setBjTime(String bjTime) {
        this.bjTime = bjTime;
    }

    public String getVirTime() {
        return virTime;
    }

    public void setVirTime(String virTime) {
        this.virTime = virTime;
    }
}
