/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.services.Impl;

import com.joseph.gymWeb.domain.Booking;
import com.joseph.gymWeb.domain.Member;
import com.joseph.gymWeb.repository.BookingRepo;
import com.joseph.gymWeb.services.BookingServ;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Common Sense
 */
@Service
public class BookingServImpl implements BookingServ{
    @Autowired
    private BookingRepo repo;
    @Override
    public List<Booking> listAll() 
    {
        List<Booking> bookings = repo.findAll();
        List<Booking> all = new ArrayList();
        for(Booking a : bookings)
        {
            all.add(a);
        }
        return bookings;
    }

    @Override
    public List<Booking> listMembers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
