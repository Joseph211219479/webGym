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
 * @author Common Sense
 */
@Entity
public class Visitor implements Serializable{
    private  static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String visitorId;
    private String hostId;
    
    private Visitor(){}
    
    private Visitor(Builder build)
    {
        this.name = build.name;
        this.visitorId = build.visitorId;
        this.hostId = build.hostId;
        this.id = build.id;
    }
    
    public static class Builder
    {
         private String name;
        private String visitorId;
        private String hostId;
        private Long id;
        
        public Builder(String visitorId)
        {
            this.visitorId = visitorId;
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
        public Builder hostId(String hostId)
        {
            this.hostId = hostId;
            return this;
        }
        public Visitor build()
        {
            return new Visitor (this);
        }
    }
    
    public String getName() {
        return name;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public String getHostId() {
        return hostId;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Visitor other = (Visitor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Visitor{" + "id=" + id + '}';
    }
    
}
