/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author student
 */
@Entity
public class Account implements Serializable{
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountHolder;
    private double amountDue;
    
    private Account(Builder build)
    {
        this.id             =  build.id;
        this.accountHolder  =  build.accountHolder;
        this.amountDue      =  build.amountDue;
                        
    }
    
    public Account() {
    }
    
    public static class Builder
    {
           private Long id;
           private String accountHolder;
           private double amountDue;
           
        public Builder(Long accountId)
        {
            this.id = id;
        }
    
        
        public Builder amountDue(double amountDue)
        {
            this.amountDue = amountDue;
            return this;
        }
        public Builder accountHolder(String accountHolder)
        {
            this.accountHolder = accountHolder;
            return this;
        }
        
        public Account build()
        {
            return new Account(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getAmountDue() {
        return amountDue;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Account other = (Account) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + '}';
    }
    
}
