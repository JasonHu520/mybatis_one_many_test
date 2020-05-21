package com.huzong.dao;

import com.huzong.domain.Account;
import com.huzong.domain.AccountUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IAccountDao {
    /**
     *查询所有,无参注解
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();

    List<AccountUser> findAllAccount();

    /**
     * 带参注解
     * @param accountID
     * @return
     */
    @Select({"select * from account where id= #{accountID}"})
    Account findAccountById(@Param(value = "accountID") int accountID);
}
