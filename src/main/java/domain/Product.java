/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author student
 */
@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private int stockAmount;
    private double price;
    
    public Product(){}
    private Product(Builder build)
    {
        this.id = build.id;
        this.name = build.name;
        this.price = build.price;
        this.stockAmount = build.stockAmount;
    }
    
    public static class Builder
    {
        private String name;
        private Long id;
        private int stockAmount;
        private double price;
        
        public Builder(Long id)
        {
            this.id = id;
        }
        public Builder name(String name)
        {
            this.name = name;
            return this;
        }
        public Builder stockAmount(int amount)
        {
            stockAmount = amount;
            return this;
        }
        public Builder price(double price)
        {
            this.price = price;
            return this;
        }
        public Product build()
        {
            return new Product(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + '}';
    }
    
}
