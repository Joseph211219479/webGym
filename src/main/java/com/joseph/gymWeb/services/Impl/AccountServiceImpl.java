/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.services.Impl;

import com.joseph.gymWeb.domain.Account;
import com.joseph.gymWeb.repository.AccountRepo;
import com.joseph.gymWeb.services.AccountService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Common Sense
 */
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepo repo;
    @Override
    public List<Account> acountList(double acountList) {
        List<Account> list = new ArrayList();
        List<Account> all = repo.findAll();
        for(Account a : all)
        {
            if(a.getAmountDue() > acountList)
            {
                list.add(a);
            }
                    }
        return list;
    }

    @Override
    public List<Account> accountLes(double amount) {
        List<Account> list = new ArrayList();
        List<Account> all = repo.findAll();
        for(Account a : all)
        {
            if(a.getAmountDue() < amount)
            {
                list.add(a);
            }
                    }
        return list;
    }

    @Override
    public List<Account> listAll() {
         //List<Account> list = new ArrayList();
        List<Account> all = repo.findAll();
        
        return all;
    }
    
    
}
