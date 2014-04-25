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
public class Member implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    
    public Member(){ }
    
    private Member(Builder builder)
    {
        id    = builder.id;
        firstname   = builder.firstname;
        lastname    = builder.lastname;
    }
     
    public static class Builder
    {
        private Long id;
        private String firstname;
        private String lastname;
        
        public Builder(Long memberId)
        {
            this.id = id;
        }
        public Builder firstName(String val)
        {
            firstname = val;
            return this;
        }
        public Builder lastName(String val)
        {
            lastname = val;
            return this;
        }
        
        public Member build()
        {
            return new Member(this);
        }
        
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + '}';
    }
    
     
}
