/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.joseph.gymWeb.app.ConnectionConfig;
import com.joseph.gymWeb.domain.Account;
import com.joseph.gymWeb.domain.Member;
import com.joseph.gymWeb.repository.MemberRepo;
import com.joseph.gymWeb.services.MemberServ;
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
public class MemberServTest {
    public static ApplicationContext ctx;
    private MemberRepo repo;
    private MemberServ serv;
    
    public MemberServTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testServALL() 
     {
         repo = ctx.getBean(MemberRepo.class);
         serv = ctx.getBean(MemberServ.class);
         
         repo = ctx.getBean(MemberRepo.class);
        serv = ctx.getBean(MemberServ.class);
        Account account = new Account.Builder("1234").
                 accountHolder("joseph").
                 amountDue(00.00).
                 build();
         Member member = new Member.Builder("98765").
                 firstName("Joseph").
                 lastName("davids").
                 account(account).
                 build();
         
         Account account2 = new Account.Builder("ljuf").
                 accountHolder("user2").
                 amountDue(00.00).
                 build();
         Member member2 = new Member.Builder("ljuf").
                 firstName("user2").
                 lastName("user2").
                 account(account2).
                 build();
         repo.save(member);
         repo.save(member2);
         
         List<Member> total = serv.memberList();
         Assert.assertEquals(total.size(), 2);
     }
//     @Test
//     public void searchByIDTest()
//     {
//         repo = ctx.getBean(MemberRepo.class);
//         serv = ctx.getBean(MemberServ.class);
//         
//        Account account = new Account.Builder("1234").
//                 accountHolder("joseph").
//                 amountDue(00.00).
//                 build();
//         Member member = new Member.Builder("98765").
//                 firstName("Joseph").
//                 lastName("davids").
//                 account(account).
//                 build();
//         
//         Account account2 = new Account.Builder("ljuf").
//                 accountHolder("user2").
//                 amountDue(00.00).
//                 build();
//         Member member2 = new Member.Builder("ljuf").
//                 firstName("user2").
//                 lastName("user2").
//                 account(account2).
//                 build();
//         repo.save(member);
//         repo.save(member2);
//         
//         Member mem = serv.searchByID("ljuf");
//         Assert.assertEquals(mem.getMemId(), "ljuf");
//     }
     
     @Test
     public void searchFullTest()
     {
         repo = ctx.getBean(MemberRepo.class);
         serv = ctx.getBean(MemberServ.class);
         
        Account account = new Account.Builder("1234").
                 accountHolder("joseph").
                 amountDue(00.00).
                 build();
         Member member = new Member.Builder("98765").
                 firstName("Joseph").
                 lastName("davids").
                 account(account).
                 build();
         
         Account account2 = new Account.Builder("ljuf").
                 accountHolder("user2").
                 amountDue(00.00).
                 build();
         Member member2 = new Member.Builder("ljuf").
                 firstName("user2").
                 lastName("user2").
                 account(account2).
                 build();
         repo.save(member);
         repo.save(member2);
         
         List<Member> mem = serv.searchByFullname(member2.getLastname(), member2.getFirstname());
         Assert.assertEquals(mem.size(), 1);
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
        repo= ctx.getBean(MemberRepo.class);
        repo.deleteAll();
    }
}
