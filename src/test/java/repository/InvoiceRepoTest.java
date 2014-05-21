/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.joseph.gymWeb.app.ConnectionConfig;
import com.joseph.gymWeb.domain.Invoice;
import com.joseph.gymWeb.domain.Product;
import com.joseph.gymWeb.repository.InvoiceRepo;
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
public class InvoiceRepoTest {
    public static ApplicationContext ctx;
    private InvoiceRepo repo;
    private Long id;
    
    public InvoiceRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void create() 
     {
         repo = ctx.getBean(InvoiceRepo.class);
         List<Product> product = new ArrayList();
         Product prod1 = new Product.Builder("jhew").
                 name("usn muscle mass").
                 price(200.00).
                 stockAmount(10).
                 build();
         product.add(prod1);
         
         Invoice invoice = new Invoice.Build("jhgsdf").
                 product(product).
                 total(200.00).
                 build();
         
         repo.save(invoice);
         id = invoice.getId();
         Assert.assertNotNull(invoice);
     }
     @Test(dependsOnMethods = "create")
     public void read()
     {
         repo = ctx.getBean(InvoiceRepo.class);
         Invoice invoice = repo.findOne(id);
         Assert.assertEquals(invoice.getTotal(), 200.00);
     }
     @Test(dependsOnMethods = "read")
     public void update()
     {
         repo = ctx.getBean(InvoiceRepo.class);
         Invoice invoice = repo.findOne(id);
         Invoice update = new Invoice.Build("jhgsdf").
                 invoice(invoice).
                 total(190.00).
                 build();
         
         repo.save(update);
         Invoice updated = repo.findOne(id);
         Assert.assertEquals(updated.getTotal(), 190.00);
     }
     @Test(dependsOnMethods = "update")
     public void delete()
     {
          repo = ctx.getBean(InvoiceRepo.class);
          Invoice invoice = repo.findOne(id);
          repo.delete(invoice);
          Invoice deleted = repo.findOne(id);
          Assert.assertNull(deleted);
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
