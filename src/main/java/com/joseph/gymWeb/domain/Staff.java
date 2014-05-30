/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author student
 */
@Entity
public class Staff implements Serializable{
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
     private String name;
     @Column(nullable = true)
    private String number;
    private String staffId;
    //Maintenance string maintenace ;
    @Column(nullable = true)
    private String isTrainer;
    
    private Staff(){}
    private Staff(Builder build)
    {
        this.staffId = build.staffId;
        this.isTrainer = build.isTrainer;
        this.name = build.name;
        this.number = build.number;
        this.id = build.id;
    }
    public static class Builder
            {
                private String name;
                private String number;
                private String staffId;
                //Maintenance string maintenace ;
                private String isTrainer;
                private Long id;
                
                public Builder(String staffId)
                {
                    this.staffId = staffId;
                }
                public Builder id(Long id)
                {
                    this.id = id;
                    return this;
                }
                public Builder name(String name)
                {
                    this.name = name;
                    return this;
                }
                public Builder number(String number)
                {
                    this.number = number;
                    return this;
                }
                
                public Builder isTrainer(String certified )
                {
                    this.isTrainer = certified;
                    return this;
                }
                public Builder staff(Staff staff)
                {
                    this.id = staff.getId();
                    this.isTrainer = staff.isIsTrainer();
                    this.name = staff.getName();
                    this.staffId = staff.getStaffId();
                    this.number = staff.getNumber();
                    
                    return this;
                }
                public Staff builder()
                {
                    return new Staff(this);
                }
            }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getStaffId() {
        return staffId;
    }

    public String isIsTrainer() {
        return isTrainer;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Staff other = (Staff) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
