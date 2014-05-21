/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.joseph.gymWeb.app.ConnectionConfig;
import com.joseph.gymWeb.domain.Account;
import com.joseph.gymWeb.domain.Compitition;
import com.joseph.gymWeb.domain.Member;
import com.joseph.gymWeb.repository.CompititionRepo;
import java.util.ArrayList;
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
public class CompititionRepoTest {
    private CompititionRepo repo;
    public static ApplicationContext ctx ;
    private Long id;
    
    
    public CompititionRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void create() 
     {
         repo = ctx.getBean(CompititionRepo.class);
         List<Member> member = new ArrayList();
         Account account1 = new Account.Builder("123123245").
                 accountHolder("piet").
                 amountDue(00.00).
                 build();
         
         Member member1 = new Member.Builder("76123254").
                 account(account1).
                 firstName("Joseph").
                 lastName("Davids").
                 build();
         member.add(member1);
         
         Compitition compitition = new Compitition.Build("1232").
                 member(member).
                 name("Strong man").
                 prize("respect").
                 date("02/06/2014").
                 build();
         repo.save(compitition);
         id = compitition.getId();
         
         Assert.assertNotNull(compitition);
     }
     
          
     @Test(dependsOnMethods = "create")
     public void read()
     {
         repo = ctx.getBean(CompititionRepo.class);
         Compitition comp = repo.findOne(id);
         
         Assert.assertEquals(comp.getName(), "Strong man");
     }
     
     @Test(dependsOnMethods = "read")
     public void update()
     {
         repo = ctx.getBean(CompititionRepo.class);
         Compitition comp = repo.findOne(id);
         Compitition updated= new Compitition.Build("983drt").
                 compitition(comp).
                 name("Iron man").
                 build();

         repo.save(updated);
         Compitition compitition = repo.findOne(id);
         Assert.assertEquals(compitition.getName(), "Iron man");
     }
     
     @Test(dependsOnMethods = "update")
     private void delete()
     {
         repo = ctx.getBean(CompititionRepo.class);
         Compitition con = repo.findOne(id);
         repo.delete(con);
         
         Compitition delete = repo.findOne(id);
         Assert.assertNull(delete);
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
