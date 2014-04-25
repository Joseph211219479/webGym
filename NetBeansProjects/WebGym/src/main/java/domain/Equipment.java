/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

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

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }
    
}
