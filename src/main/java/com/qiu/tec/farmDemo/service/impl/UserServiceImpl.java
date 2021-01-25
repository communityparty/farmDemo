package com.qiu.tec.farmDemo.service.impl;

import com.qiu.tec.farmDemo.domain.User;
import com.qiu.tec.farmDemo.mapper.Usermapper;
import com.qiu.tec.farmDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    Usermapper usermapper;


    @Override
    public void insert_userMessage(String userName, String cuteName, String age, String registDay, String virRegistday) {
        usermapper.insert_userMessage(userName,cuteName,age,registDay,virRegistday);
    }

    @Override
    public User selectRegistInfo(String userName) {
        User user = usermapper.selectRegistInfo(userName);
        return user;
    }

    @Override
    public void insert_virTime(String bjTime, String virTime) {
        usermapper.insert_virTime(bjTime,virTime);
    }

    @Override
    public String CurrentVirTime() {
        return usermapper.CurrentVirTime();
    }


}
