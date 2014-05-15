/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Common Sense
 */
@Embeddable
public class Trainer {
    private String name;
    private String trainerId;
    private String number;
    private final static long serialVersionUID = 1L;
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Trainer(){}
    private Trainer(Build builder)
    {
        this.name = builder.name;
        this.trainerId = builder.trainerId;
        this.number = builder.number;
    }

    public String getName() {
        return name;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public String getNumber() {
        return number;
    }
    
    public static class Build
    {
        private String name;
        private String trainerId;
        private String number;
        private Long id;
        
        public Build(String trainerId)
        {
            this.trainerId = trainerId;
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
        public Build number(String number)
        {
            this.number = number;
            return this;
        }
        public Trainer builder()
        {
            return new Trainer(this);
        }
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Trainer{" + "id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Trainer other = (Trainer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
