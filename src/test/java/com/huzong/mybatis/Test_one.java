package com.huzong.mybatis;

import com.huzong.dao.IAccountDao;
import com.huzong.dao.IUserDao;
import com.huzong.domain.Account;
import com.huzong.domain.AccountUser;
import com.huzong.domain.user_new;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by JasonHu 2020/5/19 22:51
 * @version 1.0
 */
public class Test_one {
    private SqlSession sqlSession;
    @Before
    public void test(){
        try {
            InputStream in = Resources.getResourceAsStream("mybatis_config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            sqlSession= factory.openSession();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    @Test
//    public void test_findAll(){
//        try {
//            InputStream in = Resources.getResourceAsStream("mybatis_config.xml");
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//            SqlSession sqlSession = factory.openSession();
//            IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
//
//            for(Account account :accountDao.findAll()){
//                System.out.println(account);
//            }
//            sqlSession.close();
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    @Test
    public void test_findALLAccount(){
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        for(AccountUser au:accountDao.findAllAccount()){
            System.out.println(au);
        }
    }
    @After
    public void destroy(){
        if(sqlSession!=null)
        {
            sqlSession.close();
        }
    }

    @Test
    public void test_findById(){
        try {
            List<String> stringList = new ArrayList<>();
            stringList.add("123");
            String s=stringList.remove(0);
            System.out.println(s);
//            InputStream in = Resources.getResourceAsStream("mybatis_config.xml");
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//            SqlSession sqlSession = factory.openSession();
//            IUserDao userDao = sqlSession.getMapper(IUserDao.class);
//            System.out.println(userDao.findUserById(10));
//
//            sqlSession.commit();
//            sqlSession.close();
//            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void test_first_cache(){
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        Account account = accountDao.findAccountById(1);
        sqlSession.clearCache();//清除缓存
        Account account1 = accountDao.findAccountById(1);
        System.out.println(account==account1);
    }
    /**
     * 测试注解
     */
    @Test
    public void test_annotation(){
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        for(Account account:accountDao.findAll())
            System.out.println(account);
    }

}
