/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author student
 */
@Entity
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Embedded
    private Contack contact;
    
    @OneToMany(cascade = CascadeType.ALL)
    List<Member> member;
    
    private int avail;
    private String bookingId;
    
    private Booking (Builder builder)
    {
        this.member = builder.member;
        //this.schedule = builder.schedule;
        //this.id = builder.id;
        this.avail = builder.avail;
        this.bookingId = builder.bookingId;
        this.id = builder.id;
        
        
    }
    
    private Booking(){}
    
    public static class Builder
    {
        private List<Member> member;
        //private List<Schedule> schedule;
        private Long id;
        private int avail;
        private String bookingId;
        
         public Builder(String bookingId)
        {
            this.bookingId = bookingId;
        }
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }
        public Builder avail(int avail)
        {
            this.avail = avail;
            return this;
        }
        public Builder member(List<Member> member)
        {
            this.member = member;
            return this;
        }
        
        public Builder booking(Booking booking)
        {
            member = booking.getMember();
            id = booking.getId();
            avail = booking.getAvail();
            bookingId = booking.getBookingId();
            
            return this;
        }
      
        public Booking builder()
        {
            return new Booking(this);
        }
    }

    public String getBookingId() {
        return bookingId;
    }

    public Long getId() {
        return id;
    }

    public Contack getContact() {
        return contact;
    }

    public List<Member> getMember() {
        return member;
    }

    public int getAvail() {
        return avail;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Booking other = (Booking) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Booking{" + "id=" + id + '}';
    }
   
}
