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
 * @author student
 */
@Entity
public class Contrack implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String type;
    private String signUp;
    private String endDate;
    private  String duration;
    
    public Contrack(){}
    
    private Contrack(Builder builder)
    {
        id = builder.id;
        signUp = builder.signUp;
        type = builder.type;
        endDate = builder.endDate;
        duration = builder.duration;
    }
    
    public static class Builder
    {
         private String type;
        private  Long id;
        private  String signUp;
        private  String endDate;
        private  String duration;
        
        public Builder(Long val)
        {
            this.id = val;
        }
        
        public Builder duration(String val)
        {
            duration= val;
            return this;
        }
        
        public Builder endDate(String val)
        {
            endDate= val;
            return this;
        }
        public Builder type(String val)
        {
            type= val;
            return this;
        }
        public Builder signUp(String val)
        {
            signUp = val;
            return this;
        }
        
        public Contrack build()
        {
            return new Contrack(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Contrack other = (Contrack) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSignUp() {
        return signUp;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Contrack{" + "id=" + id + '}';
    }
    
}
