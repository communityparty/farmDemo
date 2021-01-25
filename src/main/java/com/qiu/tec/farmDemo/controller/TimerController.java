package com.qiu.tec.farmDemo.controller;

import com.qiu.tec.farmDemo.domain.User;
import com.qiu.tec.farmDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TimerController {

    @Autowired
    UserService userService;

    /**
     * 功能描述：每1分钟向打印一次虚拟时间
     */
    @Scheduled(cron="1 * * * * ?")
    public void writeTime () throws ParseException {

        TimerController timerController = new TimerController();
        //当前日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //注册日期
        User users = userService.selectRegistInfo("zhaoli");

        //计算当前时间与虚拟时间的时间差
        //当前设定：每过1分钟虚拟时间过1天
        long minute = timerController.calculTime(users.getBirthDay(),simpleDateFormat.format(new Date()));
        Date date = new Date();
        date.setTime(date.getTime() + minute*24*60*60*1000*30);
        System.out.println("打印北京时间是："+simpleDateFormat.format(new Date()));
        System.out.println("我正在打印虚拟时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));

        //将虚拟时间写入数据库
        userService.insert_virTime(simpleDateFormat.format(new Date()),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));

        //计算当前用户在线时长
        //当前的虚拟时间-用户注册的虚拟时间
        long onlineTime = timerController.calculOnlineTime(users.getVirRegistday(),userService.CurrentVirTime());
        System.out.println("当前在线时长："+onlineTime);








    }

    /**
     * 功能描述：计算注册日期和当前止期的时间差：
     * @param starTime 注册日期
     * @param EndTime 当前日期
     * @return
     * @throws ParseException
     */
    public long calculTime (String starTime, String EndTime) throws ParseException {
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = df.parse(starTime);
        Date d2 = df.parse(EndTime);
        long diff = d2.getTime() - d1.getTime();
//        long days = diff / (1000 * 60 * 60 * 24); //天
//        long hour = diff / (1000 * 60 * 60); //小时
        long minute = diff / (1000 * 60); //分钟
        System.out.println("注册日期与北京时间差是："+minute);
//        if (days == 365 || days == 366 || days == 1094 || days == 1095 || days == 1096 || days == 1098){
//            return true;
//        }else {
//            return false;
//        }
        return minute;
    }

    /**
     * 功能描述：计算当前在线时长
     * @param starTime
     * @param EndTime
     * @return
     * @throws ParseException
     */
    public long calculOnlineTime (String starTime, String EndTime) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = df.parse(starTime);
        Date d2 = df.parse(EndTime);
        long diff = d2.getTime() - d1.getTime();
        long days = diff / (1000 * 60 * 60 * 24); //天
        System.out.println("注册日期与北京时间差是："+days+"天");
        long currentAge = days%365;
        return currentAge;
    }

}
