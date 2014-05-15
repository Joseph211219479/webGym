/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.joseph.gymWeb.repository.AccountRepo;
import com.joseph.gymWeb.app.ConnectionConfig;
import com.joseph.gymWeb.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Common Sense
 */
public class AccountRepoTest {
    public static ApplicationContext ctx;
    private Long id;
    private AccountRepo repo;
    
    public AccountRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createAccount() 
     {
         repo = ctx.getBean(AccountRepo.class);
         Account account = new Account.Builder("holder1").accountHolder("some").
                 amountDue(123.34).
                 build();
         
            repo.save(account);
         id = account.getId();
         Assert.assertNotNull(account);
     }
     
     
     @Test(dependsOnMethods = "createAccount")
     public void read()
     {
         repo = ctx.getBean(AccountRepo.class);
         Account account = repo.findOne(id);
         
         Assert.assertEquals(account.getAccountHolder(), "some");
     }
     
     @Test(dependsOnMethods = "read")
     public void update()
     {
         repo = ctx.getBean(AccountRepo.class);
         Account account = repo.findOne(id);
         Account updateAccount = new Account.Builder("holder1")
                 .account(account)
                 .accountHolder("Joseph")
                 .build();
         
         repo.save(updateAccount);
         Account newAccount = repo.findOne(id);
         Assert.assertEquals(newAccount.getAccountHolder(), "Joseph");
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
    }
}
