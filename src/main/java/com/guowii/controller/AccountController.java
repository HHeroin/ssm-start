package com.guowii.controller;

import com.guowii.domain.Account;
import com.guowii.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll() {
        return "list";
    }

    @RequestMapping("/add")
    public String add(Account account) {
        accountService.saveAccount(account);
        return "redirect:/account/findAll";
    }
}
