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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author student
 */
@Entity
public class Maintenance implements Serializable{
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Embedded
    private List<Equipment> equipment ;
    
    private String nextDate;
    private double costs;
     @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "maintenance_id")
    private List<Staff> staff;
    private String buildID;
    
    private Maintenance(){}
    
    private Maintenance(Builder build)
    {
        this.costs      = build.costs;
        this.nextDate   = build.date;
        this.staff      = build.staff;
        this.equipment  = build.equipment;
        this.buildID = build.buildID;
    }
    
    public static class Builder
    {
        private List<Equipment> equipment ;
        
        private String date;
        private double costs;
        private List<Staff> staff;
        private Long id;
        private String buildID;
        
        public Builder (String buildID)
        {
            this.buildID = buildID;
        }
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }
        public Builder date(String date)
        {
            this.date = date;
            return this;
        }
        public Builder cost(double cost)
        {
            this.costs = cost;
            return this;
        }
        public Builder staff(List<Staff> staff)
        {
            this.staff = staff;
            return this;
        }
        public Builder equipment(List<Equipment> equipment)
        {
            this.equipment = equipment;
            return this;
        }
        public Builder maintenence(Maintenance maintenance)
        {
            this.buildID = maintenance.getBuildID();
            this.costs = maintenance.getCosts();
            this.date = maintenance.getNextDate();
            this.equipment = maintenance.getEquipment();
            this.staff = maintenance.getStaff();
            this.id = maintenance.getId();
            
            return this;
        }
        public Maintenance build()
        {
            return new Maintenance(this);
        }
        
    }

    public Long getId() {
        return id;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public String getNextDate() {
        return nextDate;
    }

    public double getCosts() {
        return costs;
    }

    
    public List<Staff> getStaff() {
        return staff;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public String getBuildID() {
        return buildID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Maintenance other = (Maintenance) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Maintenance{" + "id=" + id + '}';
    }
    
}
