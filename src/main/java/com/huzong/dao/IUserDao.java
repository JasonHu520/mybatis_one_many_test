package com.huzong.dao;

import com.huzong.domain.user_new;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Created by JasonHu 2020/5/19 21:30
 * @version 1.0
 */
public interface IUserDao {

    @Select("select * from user_new")
    List<user_new> findAll();

    @Select("select * from user_new where id=#{userID}")
    user_new findUserById(@Param(value = "userID") int userID);
}
