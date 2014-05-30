/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.joseph.gymWeb.app.ConnectionConfig;
import com.joseph.gymWeb.domain.Equipment;
import com.joseph.gymWeb.domain.Maintenance;
import com.joseph.gymWeb.domain.Staff;
import com.joseph.gymWeb.repository.MaintenanceRepo;
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
public class MaintenanceRepoTest {
    public static ApplicationContext ctx;
    
    private Long id;
    private MaintenanceRepo repo;
    
    public MaintenanceRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void create() 
     {
         repo = ctx.getBean(MaintenanceRepo.class);
         List<Equipment> equipList = new ArrayList();
         List<Staff> staffList = new ArrayList();
         
         Staff s1 = new Staff.Builder("sdfe23")
                 .isTrainer("no").
                 name("piet").
                 number("027983735").
                 builder();
         staffList.add(s1);
         Assert.assertEquals(s1.getName(), "piet");
         
         Equipment q1 = new Equipment.Builder("sdfe23").
                 name("Joseph").
                 buyDate("22/05/2014").
                 build();
         equipList.add(q1);
         
         Maintenance main = new Maintenance.Builder("sdfe23").
                 cost(400.00).date("22/05/2014").
                 equipment(equipList).
                 staff(staffList).
                 build();
         
         repo.save(main);
         id = main.getId();
         Assert.assertNotNull(main);
     }
     @Test(dependsOnMethods = "create")
     public void read()
     {
         repo = ctx.getBean(MaintenanceRepo.class);
         Maintenance main = repo.findOne(id);
         Assert.assertEquals(main.getCosts(), 400.00);
     }
     @Test(dependsOnMethods = "read")
     public void update()
     {
         repo = ctx.getBean(MaintenanceRepo.class);
         Maintenance main = repo.findOne(id);
         Maintenance update = new Maintenance.Builder("sdfe23").
                 maintenence(main).
                 cost(500.00).
                 build();
         repo.save(update);
         //id = update.getId();
         Assert.assertEquals(update.getCosts(), 500.00);
     }
     @Test(dependsOnMethods = "update")
     public void delete()
     {
         repo = ctx.getBean(MaintenanceRepo.class);
         Maintenance main = repo.findOne(id);
         repo.delete(main);
         
         Maintenance deleted = repo.findOne(id);
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
