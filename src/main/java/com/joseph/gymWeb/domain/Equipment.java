/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;


/**
 *
 * @author student
 */
@Embeddable
public class Equipment implements Serializable{
    private String name;
    private String code;
    private String buyDate;
    
    private Equipment( Builder builder)
    {
        this.name = builder.name;
        this.code = builder.code;
        this.buyDate = builder.buyDate;
    }
    private Equipment(){}

    public static class Builder
    {
        private String name;
        private String code;
        private String buyDate;
        
        public Builder(String code)
        {
            this.code = code;
        }
        public Builder name(String name)
        {
            this.name = name;
            return this;
        }
        public Builder buyDate(String buyDate)
        {
            this.buyDate = buyDate;
            return this;
        }
        public Equipment build()
        {
            return new Equipment(this);
        }
    }
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getBuyDate() {
        return buyDate;
    }

}
