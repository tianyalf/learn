package com.ssm.dao;

import com.ssm.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date:2020-06-14 0:49
 * @author:天涯沦落人
 * @description:
 */
@Repository
public interface IAccountDao {
    @Select("select * from account")
    public List<Account> findAll();
    @Insert("insert into account(name,money) value(#{name},#{money})")
    public void saveAccount(Account account);
}
