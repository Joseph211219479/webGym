/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.services;

import com.joseph.gymWeb.domain.Account;
import java.util.List;

/**
 *
 * @author Common Sense
 */
public interface AccountService {
    public List<Account> acountList(double amount) ;
    public List<Account> accountLes(double amount);
    public Account findaccount(String accountId);
    public List<Account> listAll();
}
