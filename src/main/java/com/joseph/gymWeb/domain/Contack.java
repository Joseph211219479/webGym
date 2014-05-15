/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
//import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author student
 */
@Embeddable
public class Contack implements Serializable{
    private String name ;
    private String number;
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.number);
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
        final Contack other = (Contack) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        return true;
    }

    private Contack(){}
    public Contack(Builder builder)
    {
        //id = builder.id;
        number = builder.number;
        name = builder.name;
    }
     public static class Builder
    {
         private String name ;
         private String number;
        // private Long id;
         
         
         public Builder(String number)
         {
             this.number = number;
            
         }
         public Builder name(String name)
         {
             this.name = name;
             return this;
         }
         
         public Builder id(Long id)
        {
           // this.id = id;
            return this;
        }
         
         public Builder contack(Contack cont)
         {
             name = cont.getName();
             number = cont.getNumber();
            // id = cont.getId();
             return this;
         }
         public Contack build()
         {
             return new Contack(this);
         }
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

//    public Long getId() {
//        return id;
//    }


    
 
}
