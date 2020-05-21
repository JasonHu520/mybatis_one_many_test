package com.huzong.dao;

import com.huzong.domain.user_new;

import java.util.List;

/**
 * @author Created by JasonHu 2020/5/19 21:30
 * @version 1.0
 */
public interface IUserDao {
    List<user_new> findAll();
    user_new findUserById(int userID);
}
