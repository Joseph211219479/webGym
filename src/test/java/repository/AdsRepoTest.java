/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.joseph.gymWeb.app.ConnectionConfig;
import com.joseph.gymWeb.domain.Ads;
import com.joseph.gymWeb.repository.AdsRepo;
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
public class AdsRepoTest {
     public static ApplicationContext ctx;
    private Long id;
    private AdsRepo repo;
    
    public AdsRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createAds() 
     {
         repo = ctx.getBean(AdsRepo.class);
         Ads ads = new Ads.Build("1254").
                 endDate("02/06/2014").
                 startdate("30/05/2014").
                 build();
         
         repo.save(ads);
         id = ads.getId();
         Assert.assertNotNull(id);
                 
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
