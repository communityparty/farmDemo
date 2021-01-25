package com.qiu.tec.farmDemo.controller;

import com.qiu.tec.farmDemo.domain.User;
import com.qiu.tec.farmDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * 功能描述：注册用户
 */
@Component
@RestController
@RequestMapping("/api/v1/farmer")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user")
    public void registUser() throws ParseException {

        TimerController timerController = new TimerController();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        User user = new User();

        System.out.println("请输入姓名：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println("接收到的姓名内容是："+str);


        System.out.println("请输入年龄：");
        Scanner scanner2 = new Scanner(System.in);
        String str2 = scanner2.next();
        System.out.println("接收到的年龄内容是："+str2);


        System.out.println("请输入昵称：");
        Scanner scanner3 = new Scanner(System.in);
        String str3 = scanner3.next();
        System.out.println("接收到的昵称内容是："+str3);


        System.out.println("获取内容结束，输入关闭！");
        scanner.close();
        scanner2.close();
        scanner3.close();

        user.setUserName(str);
        user.setAge(str2);
        user.setCuteName(str3);
        user.setBirthDay(simpleDateFormat.format(new Date()));

        //计算当前时间与虚拟时间的时间差
        //当前设定：每过1分钟虚拟时间过1天
        long minute = timerController.calculTime(user.getBirthDay(),simpleDateFormat.format(new Date()));
        Date date = new Date();
        date.setTime(date.getTime() + minute*24*60*60*1000);
        System.out.println("打印北京时间是："+simpleDateFormat.format(new Date()));
        System.out.println("我正在打印虚拟时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));

        user.setVirRegistday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));

        userService.insert_userMessage(user.getUserName(),user.getCuteName(),user.getAge(),user.getBirthDay(),user.getVirRegistday());

    }


}
