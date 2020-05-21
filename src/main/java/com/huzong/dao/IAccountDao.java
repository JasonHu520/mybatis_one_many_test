package com.huzong.dao;

import com.huzong.domain.Account;
import com.huzong.domain.AccountUser;
import com.huzong.domain.UserAccount;
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

    /**
     * 查找所有的账户
     * @return
     */
    @Select("select a.*,u.username,u.address from user_new u,account a where u.id=a.UID")
    List<AccountUser> findAllAccount();

    /**
     * 带参注解
     * @param accountID
     * @return
     */
    @Select({"select * from account where id= #{accountID}"})
    Account findAccountById(@Param(value = "accountID") int accountID);

    /**
     * 查找所有用户
     * @return
     */
    @Select("select u.*,a.MONEY,a.UID from user_new u,account a where u.id=a.UID;")
    List<UserAccount> findAllUser();
}
