package com.qiu.tec.farmDemo.mapper;

import com.qiu.tec.farmDemo.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface Usermapper {

    //保存用户的注册信息
    @Insert("INSERT INTO farmer.`user` (userName,cuteName,age,registDay,vir_registday) VALUES (#{userName},#{cuteName},#{age},#{registDay},#{virRegistday})")
    void insert_userMessage(@Param("userName") String userName,@Param("cuteName") String cuteName,
                            @Param("age") String age,@Param("registDay") String registDay,@Param("virRegistday") String virRegistday);

    //读取用户注册信息
    @Select("SELECT * FROM farmer.`user` WHERE userName = #{userName}")
    @Results({
            @Result(property = "userName",column = "userName"),
            @Result(property = "cuteName",column = "cuteName"),
            @Result(property = "age",column = "age"),
            @Result(property = "birthDay",column = "registDay"),
            @Result(property = "virRegistday",column = "vir_registday")
    })
    User selectRegistInfo(String userName);


    //保存虚拟时间信息
    @Insert("INSERT INTO farmer.sys_time (BJ_time,vir_time) VALUES (#{bjTime},#{virTime})")
    @Results({
            @Result(property = "bjTime", column = "BJ_time"),
            @Result(property = "virTime", column = "vir_time")
    })
    void insert_virTime(@Param("bjTime") String bjTime,@Param("virTime") String virTime);

    //读取当前的虚拟时间信息
    @Select("SELECT MAX(vir_time) FROM (SELECT vir_time FROM farmer.sys_time)t")
    String CurrentVirTime();


}
