/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.joseph.gymWeb.app.ConnectionConfig;
import com.joseph.gymWeb.domain.Account;
import com.joseph.gymWeb.domain.Booking;
import com.joseph.gymWeb.domain.Member;
import com.joseph.gymWeb.repository.BookingRepo;
import com.joseph.gymWeb.services.BookingServ;
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
import static repository.BookingRepoTest.ctx;

/**
 *
 * @author Common Sense
 */
public class BookingServTest {
    public static ApplicationContext ctx;
    private BookingServ serv;
    private BookingRepo repo;
    
    public BookingServTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testServAll() 
     {
         repo = ctx.getBean(BookingRepo.class);
         serv = ctx.getBean(BookingServ.class);
         
         repo = ctx.getBean(BookingRepo.class);
         //Account accountList = new ArrayList(); 
         List<Member> memberList = new ArrayList();
         
         Account account1 = new Account.Builder("12345").
                 accountHolder("piet").
                 amountDue(00.00).
                 build();
         //accountList.add(account1);
         
         Member member1 = new Member.Builder("12345").
                 firstName("piet").
                 lastName("ok").
                 account(account1).
                 build();
         
         memberList.add(member1);
         
         Booking booking1 = new Booking.Builder("12345").
                 avail(5).
                 member(memberList).
                 builder();
         Booking booking2 = new Booking.Builder("jhgsd67").
                 avail(3).
                 member(memberList).
                 builder();
         
         repo.save(booking1);
         repo.save(booking2);
         
         List<Booking> bookingList = serv.listAll();
         Assert.assertEquals(bookingList.size(), 2);
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
        repo = ctx.getBean(BookingRepo.class);
        repo.deleteAll();
    }
}
