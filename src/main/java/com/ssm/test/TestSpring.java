package com.ssm.test;

import com.ssm.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date:2020-06-14 1:00
 * @author:天涯沦落人
 * @description:
 */
public class TestSpring {
    @Test
    public void run1(){
        ApplicationContext ap = new ClassPathXmlApplicationContext("classPath:applicationConfig.xml");
        IAccountService as = (IAccountService)ap.getBean("accountService");
        as.findAll();
    }
}
