/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    List<Equipment> equipment ;
    private String nextDate;
    private double costs;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    List<Staff> staff;
    
    public Maintenance(){}
    private Maintenance(Builder build)
    {
        this.costs = build.costs;
        this.nextDate = build.date;
        this.staff = build.staff;
        this.equipment = build.equipment;
    }
    
    public static class Builder
    {
        private List<Equipment> equipment ;
        private String date;
        private double costs;
        private List<Staff> staff;
        private Long id;
        
        public Builder (Long id)
        {
            this.id = id;
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
    public String toString() {
        return "Maintenance{" + "id=" + id + '}';
    }
    
}
