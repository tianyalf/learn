package com.ssm.controller;

import com.ssm.domain.Account;
import com.ssm.service.IAccountService;
import com.ssm.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @date:2020-06-14 1:12
 * @author:天涯沦落人
 * @description:
 */
@Controller
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/account/findAll")
    public String findAll(Model model){
        System.out.println("Controller表现层：查询所有账户...");
        List<Account> list=accountService.findAll();
        model.addAttribute("list",list);
        return "list";  //在视图解析器中配置了前缀后缀
    }

    @RequestMapping("/account/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response)throws IOException {
        accountService.savaAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}
