/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    
     private int staffId;
    private double amount;
    private List<Staff> staff;
    
    private Payroll()
    {}
    
    private Payroll( Builder builder )
    {
        amount = builder.amount;
        staffId = builder.staffId;
        staff = builder.staff;
        id = builder.id;
    }
    
    public static class Builder
    {
        private int staffId;
        private double amount;
        private List<Staff> staff;
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
            staffId = value;
            return this;
        }
        
        public Builder staff( List<Staff> values )
        {
            staff = values;
            return this;
        }
        
        public Payroll build()
        {
            return new Payroll(this);
        }
    }

    public int getStaffId() {
        return staffId;
    }

    public double getAmount() {
        return amount;
    }

    public List<Staff> getStaff() {
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
