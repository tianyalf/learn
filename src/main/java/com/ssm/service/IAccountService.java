package com.ssm.service;

import com.ssm.domain.Account;

import java.util.List;

/**
 * @date:2020-06-14 0:51
 * @author:天涯沦落人
 * @description:
 */
public interface IAccountService {
    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存账户信息
     * @param account
     */
    public void savaAccount(Account account);
}
