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
public class Profile implements Serializable{
    private String name;
    private String surname;
    private int age;
    private double weight;
    private double height;
    private String goal;
    private String memberId;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public String getGoal() {
        return goal;
    }

    public String getMemberId() {
        return memberId;
    }
    
    
}
