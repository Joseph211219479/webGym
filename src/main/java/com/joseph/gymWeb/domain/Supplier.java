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
public class Supplier implements Serializable{
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
     private String name;
    private String number;
    private String supId;
    
    private Supplier(){}
    private Supplier(Build build)
    {
        this.name = build.name;
        this.number = build.number;
        this.supId = build.supId;
        this.id = build.id;
      
        }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getSupId() {
        return supId;
    }
    public Long getId() {
        return id;
    }
      
        public static class Build
        {
            private String name;
            private String number;
            private String supId;
            private Long id;
    
            public Build(String supId)
            {
                this.supId = supId;
            }
            public Build id(Long id)
            {
                this.id= id;
                return this;
            }
            public Build number(String number)
            {
                this.number = number;
                return this;
            }
            public Build name(String name)
            {
                this.name = name;
                return this;
            }
            
            Supplier build()
            {
                return new Supplier(this);
            }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Supplier other = (Supplier) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Supplier{" + "id=" + id + ", supId=" + supId + '}';
    }
    
}
