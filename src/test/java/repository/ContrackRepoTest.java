/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.joseph.gymWeb.app.ConnectionConfig;
import com.joseph.gymWeb.domain.Account;
import com.joseph.gymWeb.domain.Contrack;
import com.joseph.gymWeb.repository.ContrackRepo;
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
public class ContrackRepoTest {
    public static ApplicationContext ctx;
    private ContrackRepo repo;
    private Long id;
    
    public ContrackRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void create() 
     {
         repo = ctx.getBean(ContrackRepo.class);
         Contrack contrack = new Contrack.Builder("87sjdhf").
                 duration("24").
                 endDate("30/05/2016").
                 signUp("21/05/2014").
                 type("cash").
                 build();
         
         repo.save(contrack);
         id = contrack.getId();
         
         Assert.assertNotNull(contrack);
         
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