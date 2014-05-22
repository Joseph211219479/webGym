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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Common Sense
 */
@Entity
public class Payroll implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
     private int pId;
    private double amount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payroll_id")
    private Staff staff;
    
    private Payroll()
    {}
    
    private Payroll( Builder builder )
    {
        amount = builder.amount;
        pId = builder.pId;
        staff = builder.staff;
        id = builder.id;
    }
    
    public static class Builder
    {
        private int pId;
        private double amount;
        private Staff staff;
        private Long id;
        
        public Builder( double amount )
        {
            this.amount = amount;
        }
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }
        
        public Builder staffId( int value )
        {
            pId = value;
            return this;
        }
        
        public Builder staff( Staff staff )
        {
            this.staff = staff;
            return this;
        }
        
        public Builder payroll(Payroll pay)
        {
            this.amount = pay.getAmount();
            this.id = pay.getId();
            this.pId = pay.getStaffId();
            this.staff = pay.getStaff();
            
            return this;
        }
        
        public Payroll build()
        {
            return new Payroll(this);
        }
    }

    public int getStaffId() {
        return pId;
    }

    public double getAmount() {
        return amount;
    }

    public Staff getStaff() {
        return staff;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Payroll{" + "id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Payroll other = (Payroll) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
