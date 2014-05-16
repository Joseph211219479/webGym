/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.domain;

import java.io.Serializable;
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
public class Compitition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    private String name;
    private String date;
    private String prize;
    private String compid;
    
    private Compitition(){}
    private Compitition(Build build)
    {
        this.date = build.date;
        this.compid = build.compid;
        this.name = build.name;
        this.prize = build.prize;
        this.id = build.id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getPrize() {
        return prize;
    }
    
    public Long getId() {
        return id;
    }

    public String getCompid() {
        return compid;
    }

    public static class Build
    {
        private String name;
        private String date;
        private String prize;
        private String compid;
        private Long id;
    
        public Build(String compid)
        {
            this.compid = compid;
        }
        public Build id(Long id)
        {
            this.id = id;
            return this;
        }
        public Build name(String name)
        {
            this.name = name;
            return this;
        }
        public Build prize(String prize)
        {
            this.prize = prize;
            return this;
        }
        public Build date(String date)
        {
            this.date = date;
            return this;
        }
        public Build compitition(Compitition compitition)
        {
              this.name     = compitition.getName();
              this.date     = compitition.getDate();
                this.prize  = compitition.getPrize();
                this.compid = compitition.getCompid();
                this.id     = compitition.getId();
            
            return this;
        }
        public Compitition build()
        {
            return new Compitition(this);
        }
    }

    @Override
    public String toString() {
        return "Compitition{" + "id=" + id + '}';
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Compitition other = (Compitition) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
