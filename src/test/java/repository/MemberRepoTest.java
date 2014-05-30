/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.joseph.gymWeb.app.ConnectionConfig;
import com.joseph.gymWeb.domain.Account;
import com.joseph.gymWeb.domain.Member;
import com.joseph.gymWeb.repository.MemberRepo;
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
public class MemberRepoTest {
    private static ApplicationContext ctx;
    private Long id;
    private MemberRepo repo;
    
    public MemberRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void create() 
     {
         repo = ctx.getBean(MemberRepo.class);
         Account account = new Account.Builder("1234").
                 accountHolder("joseph").
                 amountDue(00.00).
                 build();
         Member member = new Member.Builder("98765").
                 firstName("Joseph").
                 lastName("davids").
                 account(account).
                 build();
         
         repo.save(member);
         id = member.getId();
         Assert.assertNotNull(member);
     }
     
     @Test(dependsOnMethods = "create")
     public void read()
     {
         repo = ctx.getBean(MemberRepo.class);
         Member member = repo.findOne(id);
         
         Assert.assertEquals(member.getFirstname(), "Joseph");
     }
     
     @Test(dependsOnMethods = "read")
     public void update()
     {
         repo = ctx.getBean(MemberRepo.class);
         Member member = repo.findOne(id);
         Member updateMember = new Member.Builder("98765").
                 member(member).lastName("Davids").
                 build();
         
         repo.save(updateMember);
         Member newMember = repo.findOne(id);
         Assert.assertEquals(newMember.getLastname(), "Davids");
     }
     
     @Test(dependsOnMethods = "update")
     public void delete()
     {
         repo = ctx.getBean(MemberRepo.class);
         Member member = repo.findOne(id);
         
         repo.delete(member);
         
         Member deleted = repo.findOne(id);
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
