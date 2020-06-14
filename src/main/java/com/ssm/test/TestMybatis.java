package com.ssm.test;

import com.ssm.dao.IAccountDao;
import com.ssm.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @date:2020-06-14 9:17
 * @author:天涯沦落人
 * @description:
 */
public class TestMybatis {
    @Test
    public void run1() throws IOException {
        Account account=new Account();
        account.setName("张三");
        account.setMoney(100d);
        //加载配置文件
        InputStream in= Resources.getResourceAsStream("SqlMapperConfig.xml");
        //创建sqlSessionFactory对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象
        SqlSession session=factory.openSession();
        //获取代理对象
        IAccountDao dao=session.getMapper(IAccountDao.class);

        //保存
        dao.saveAccount(account);
        //提交事务
        session.commit();
        //关闭资源
        session.close();
        in.close();
    }

    @Test
    public void run2()throws IOException{
        InputStream in=Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        SqlSession session=factory.openSession();
        IAccountDao dao=session.getMapper(IAccountDao.class);
        List<Account> list=dao.findAll();
        for(Account account:list){
            System.out.println(account);
        }
        session.close();
        in.close();
    }
}
