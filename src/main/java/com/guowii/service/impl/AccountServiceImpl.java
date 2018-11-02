package com.guowii.service.impl;

import com.guowii.dao.AccountDao;
import com.guowii.domain.Account;
import com.guowii.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
