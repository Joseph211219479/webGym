/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.presentation.rest;

import com.joseph.gymWeb.domain.Account;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Common Sense
 */
@Controller
@RequestMapping(value = "api/account")
public class AccountRestController 
{
    @RequestMapping(value = "create")
    @ResponseBody
    public String create(@RequestBody Account account)
    {
        System.out.println(" Create the Called ");
        return "";
    }
    @RequestMapping(value = "update")
    @ResponseBody
    public String update(@RequestBody Account account)
    {
        System.out.println(" update the Called ");
        return "";
    }
    @RequestMapping(value = "account/{id}")
    @ResponseBody
    public Account getAccount(@PathVariable String id)
    {
        System.out.println(" ID called ");
        return null;
    }
    
    @RequestMapping(value = "accounts")
    @ResponseBody
    public List<Account> getAccounts( )
    {
        System.out.println(" accounts ");
        return null;
    }
    
    @RequestMapping(value = "accounts/{name}")
    @ResponseBody
    public Account getaccountName(@PathVariable String id) {
        System.out.println("The account name");
        return null;
    }
    
}
