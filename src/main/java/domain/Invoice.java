/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
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
public class Invoice implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private double total;
    @Embedded
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    List<Product> product;

    public Invoice() {
    }
    
    private Invoice(Build build)
    {
        this.product = build.product;
        this.id = build.id;
        this.total = build. total;
    }
    
    public double getTotal() {
        return total;
    }

    public List<Product> getProduct() {
        return product;
    }

    public Long getId() {
        return id;
    }
    
    public static class Build
    {
        private double total;
        private List<Product> product;
        private Long id;
        
        public Build(Long id)
        {
            this.id = id;
        }
        public Build total(double total)
        {
            this.total = total;
            return this;
        }
        public Build product(List<Product> product)
        {
            this.product = product;
            return this;
        }
        public Invoice build()
        {
            return new Invoice(this);
        }
       
    }

    @Override
    public String toString() {
        return "Invoice{" + "id=" + id + '}';
    }
    
}
