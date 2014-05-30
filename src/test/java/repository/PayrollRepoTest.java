/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.joseph.gymWeb.app.ConnectionConfig;
import com.joseph.gymWeb.domain.Payroll;
import com.joseph.gymWeb.domain.Staff;
import com.joseph.gymWeb.repository.PayrollRepo;
import java.util.ArrayList;
import java.util.List;
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
public class PayrollRepoTest {
    public static ApplicationContext ctx;
    private Long id;
    private PayrollRepo repo;
    
    public PayrollRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void create() 
     {
         repo = ctx.getBean(PayrollRepo.class);

         Staff s1 = new Staff.Builder("sdfe23")
                 .isTrainer("no").
                 name("piet").
                 number("027983735").
                 builder();
         
         Assert.assertEquals(s1.getName(), "piet");
         Payroll payroll= new Payroll.Builder("jhgsdf34").
                 staff(s1).
                 amount(5000.23).
                 build();
         
         repo.save(payroll);
         id = payroll.getId();
         Assert.assertNotNull(id);
     }
     @Test(dependsOnMethods = "create")
     public void read()
     {
         repo = ctx.getBean(PayrollRepo.class);
         Payroll pay = repo.findOne(id);
         Assert.assertNotNull(pay);

     }
     @Test(dependsOnMethods = "read")
     public void update()
     {
         repo = ctx.getBean(PayrollRepo.class);

         Payroll pay = repo.findOne(id);
         Payroll update= new Payroll.Builder("jhgsdf34").
                 payroll(pay).
                 amount(6000.00).
                 build();
         
         repo.save(update);
         Payroll newp = repo.findOne(id);
         Assert.assertEquals(newp.getAmount(), 6000.00);
     }
     @Test(dependsOnMethods = "update")
     public void delete()
     {
        repo = ctx.getBean(PayrollRepo.class);
        Payroll pay = repo.findOne(id);
        repo.delete(pay);
        Payroll del = repo.findOne(id);
        Assert.assertNull(del);

     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx =new AnnotationConfigApplicationContext(ConnectionConfig.class);
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
