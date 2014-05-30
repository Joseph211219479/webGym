/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.presentation;

import com.joseph.gymWeb.domain.Account;
import com.joseph.gymWeb.services.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Common Sense
 */
@Controller

public class AccountController {
    
    
    @Autowired
    private AccountService accountservice;
    
    @RequestMapping(value = "account")
    @ResponseBody
    public Account getAccount()
    {
        Account account = null;
        List<Account> accountlist = accountservice.listAll();
        if(accountlist.size() > 0)
            account = accountlist.get(0);
        
        return account;
    }
    
    @RequestMapping(value = "account")
    @ResponseBody
    public Account findaccount(String accountId)
    {
        Account account = null;
        List<Account> accoutlist = accountservice.listAll();
        for(Account a : accoutlist)
        {
            if(a.getAccountId().equalsIgnoreCase(accountId))
                account = a;
        }
        return account;
    }
    
    @RequestMapping(value = "account")
    @ResponseBody
    public List<Account> allaccount()
    {
        List<Account> all = accountservice.listAll();
        return all;
    }
    
    
}
