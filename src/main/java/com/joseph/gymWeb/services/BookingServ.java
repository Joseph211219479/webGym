/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.services;

import com.joseph.gymWeb.domain.Booking;
import java.util.List;

/**
 *
 * @author Common Sense
 */
public interface BookingServ {
    public List<Booking> listAll();
    //public List<Booking> listDate(String date);
    public List<Booking> listMembers();
    
}
