/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.joseph.gymWeb.app.ConnectionConfig;
import com.joseph.gymWeb.domain.Ads;
import com.joseph.gymWeb.repository.AccountRepo;
import com.joseph.gymWeb.repository.AdsRepo;
import com.joseph.gymWeb.services.AdsService;
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
import static services.AccountServiceTest.ctx;

/**
 *
 * @author Common Sense
 */
public class AdsServiceTest {
    public static ApplicationContext ctx;
    private AdsRepo repo;
    private AdsService serv;
    
    public AdsServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testServ() 
     {
         repo = ctx.getBean(AdsRepo.class);
         serv = ctx.getBean(AdsService.class);
                  
         Ads ad1 = new Ads.Build("mghf6").
                 startdate("02/06/2014").
                 endDate("30/06/2014").
                 build();
         Ads ad2 = new Ads.Build("usn ads").
                 startdate("02/06/2014").
                 endDate("30/06/2014").
                 build();
         
         Ads ad3 = new Ads.Build("nutri tec").
                 startdate("02/06/2014").
                 endDate("30/06/2014").
                 build();
         
         repo.save(ad1);
         repo.save(ad2);
         repo.save(ad3);
         
         List<Ads> adslist = serv.listall();
         Assert.assertNotNull(adslist);
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
        repo = ctx.getBean(AdsRepo.class);
        repo.deleteAll();
    }
}
