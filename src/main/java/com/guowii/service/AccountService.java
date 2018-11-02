package com.guowii.service;

import com.guowii.domain.Account;

import java.util.List;

public interface AccountService {
    /***
     * 保存账号
     * @param account
     */
    void saveAccount(Account account);

    /***
     * 查询所有
     * @return
     */
    List<Account> findAll();
}
