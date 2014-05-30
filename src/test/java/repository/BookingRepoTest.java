/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.joseph.gymWeb.app.ConnectionConfig;
import com.joseph.gymWeb.domain.Account;
import com.joseph.gymWeb.domain.Booking;
import com.joseph.gymWeb.domain.Member;
import com.joseph.gymWeb.repository.BookingRepo;
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
public class BookingRepoTest {
    public static ApplicationContext ctx;
    private Long id;
    
    private BookingRepo repo ; 
    public BookingRepoTest(){}
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void create() 
     {
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
         
         Booking booking = new Booking.Builder("12345").
                 avail(5).
                 member(memberList).
                 builder();
         
         repo.save(booking);
         id = booking.getId();
         Assert.assertNotNull(booking);
         
         
     }
     
     @Test(dependsOnMethods = "create")
     public void read()
     {
         repo = ctx.getBean(BookingRepo.class);
         Booking booking = repo.findOne(id);
         
         Assert.assertEquals(booking.getBookingId(), "12345");
     }
     @Test(dependsOnMethods ="read" )
     public void update()
     {
         repo = ctx.getBean(BookingRepo.class);
         Booking booking = repo.findOne(id);
         Booking updateBook = new Booking.Builder("12345").
                 booking(booking).
                 avail(2).
                 builder();
         
         repo.save(updateBook);
         Booking newBooking = repo.findOne(id);
         Assert.assertEquals(newBooking.getAvail(), 2);
     }

     @Test(dependsOnMethods = "update")
     public void delete()
     {
         repo = ctx.getBean(BookingRepo.class);
         Booking booking = repo.findOne(id);
         repo.delete(booking);
         
         Booking deletedooking = repo.findOne(id);
         Assert.assertNull(deletedooking);
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
