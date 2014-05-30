/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author student
 */
@Embeddable
public class Excercise implements Serializable{
    private String excersiceId;
    private String name;
    private String primaryTarget;

    private Excercise(Builder build)
    {
        this.excersiceId = build.excersiceId;
        this.name = build.name;
        this.primaryTarget = build.primaryTarget;
    }

    public static class Builder
    {
        private String excersiceId;
        private String name;
        private String primaryTarget;
        
        public Builder(String excersiceId)
        {
            this.excersiceId = excersiceId;
        }
        public Builder name(String name)
        {
            this.name = name;
            return this;
        }
        public Builder primaryTarget(String primaryTarget)
        {
            this.primaryTarget = primaryTarget;
            return this;
        }
        
        public Excercise build()
        {
            return new Excercise(this);
        }
    }
    
    public String getExcersiceId() {
        return excersiceId;
    }

    public String getName() {
        return name;
    }

    public String getPrimaryTarget() {
        return primaryTarget;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.excersiceId);
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
        final Excercise other = (Excercise) obj;
        if (!Objects.equals(this.excersiceId, other.excersiceId)) {
            return false;
        }
        return true;
    }
        
}
