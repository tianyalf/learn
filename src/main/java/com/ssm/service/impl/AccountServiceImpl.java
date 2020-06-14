package com.ssm.service.impl;

import com.ssm.dao.IAccountDao;
import com.ssm.domain.Account;
import com.ssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date:2020-06-14 0:50
 * @author:天涯沦落人
 * @description:
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("service业务层：查询所有账户。。。。");
        return accountDao.findAll();
    }

    @Override
    public void savaAccount(Account account) {
        System.out.println("Service业务层：保存账户信息。。。。");
        accountDao.saveAccount(account);
    }
}
