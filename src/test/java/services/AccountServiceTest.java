/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.joseph.gymWeb.app.ConnectionConfig;
import com.joseph.gymWeb.domain.Account;
import com.joseph.gymWeb.repository.AccountRepo;
import com.joseph.gymWeb.services.AccountService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Common Sense
 */
public class AccountServiceTest {
    public static ApplicationContext ctx ;
    private AccountRepo repo;
    private AccountService service;
    
    public AccountServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testService() 
     {
         repo = ctx.getBean(AccountRepo.class);
         service = ctx.getBean(AccountService.class);
         
         Account account1 = new Account.Builder("1234").accountHolder("joseph").amountDue(1223.43).build();
         Account account2 = new Account.Builder("323").accountHolder("kjsgdfg").amountDue(123.43).build();
         Account account3 = new Account.Builder("873645").accountHolder("kyhtsgg").amountDue(00.00).build();
         
         repo.save(account1);
         repo.save(account2);
         repo.save(account3);
         
         List<Account> account = service.acountList(1000.00);
         Assert.assertEquals(account.size(), 1);
         
         
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        repo = ctx.getBean(AccountRepo.class);
        repo.deleteAll();
    }
}
