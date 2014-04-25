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
public class Excercise implements Serializable{
    private String excersiceId;
    private String name;
    private String primaryTarget;

    public String getExcersiceId() {
        return excersiceId;
    }

    public String getName() {
        return name;
    }

    public String getPrimaryTarget() {
        return primaryTarget;
    }

    public void setExcersiceId(String excersiceId) {
        this.excersiceId = excersiceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrimaryTarget(String primaryTarget) {
        this.primaryTarget = primaryTarget;
    }
    
    
}
