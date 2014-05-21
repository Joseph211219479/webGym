/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.domain;

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
    
    private String proID;
    private String name;
    private int stockAmount;
    private double price;
    
    public Product(){}
    private Product(Builder build)
    {
        this.proID = build.proID;
        this.id = build.id;
        this.name = build.name;
        this.price = build.price;
        this.stockAmount = build.stockAmount;
    }
    
    public static class Builder
    {
        private String proID;
        private String name;
        private Long id;
        private int stockAmount;
        private double price;
        
        public Builder(String proID)
        {
            this.proID = proID;
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
        public Builder product(Product product)
        {
            this.id = product.getId();
            this.name = product.getName();
            this.price = product.getPrice();
            this.stockAmount = product.getStockAmount();
            this.proID = product.getProID();
            
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

    public String getProID() {
        return proID;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + '}';
    }
    
}
