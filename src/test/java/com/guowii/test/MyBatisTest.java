package com.guowii.test;

import com.guowii.dao.AccountDao;
import com.guowii.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        sqlSession = sqlSessionFactory.openSession(true);
    }


    @Test
    public void saveTest() {
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        Account account = new Account();
        account.setName("张三");
        account.setMoney(1000d);
        mapper.saveAccount(account);
    }

    @Test
    public void findAll() {
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<Account> all = mapper.findAll();
        System.out.println(all);
    }
}
