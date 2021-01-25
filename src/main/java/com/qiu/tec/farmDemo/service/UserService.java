package com.qiu.tec.farmDemo.service;

import com.qiu.tec.farmDemo.domain.User;

import java.util.ArrayList;

public interface UserService {

    //保存用户的注册信息
    void insert_userMessage(String userName, String cuteName, String age, String registDay ,String virRegistday);

    //读取用户注册信息
    User selectRegistInfo(String userName);

    //保存虚拟时间信息
    void insert_virTime(String bjTime,String virTime);

    //读取当前的虚拟时间信息
    String CurrentVirTime();



}
