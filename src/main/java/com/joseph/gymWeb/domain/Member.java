/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import com.joseph.gymWeb.domain.Account;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
   // private Account acount ;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Account accounts;
    private String memId;
    
    private Member(){ }
    
    private Member(Builder builder)
    {
        id    = builder.id;
        firstname   = builder.firstname;
        lastname    = builder.lastname;
        memId = builder.memId;
        accounts = builder.accounts;
    }
     
    public static class Builder
    {
        private String memId;
        private Long id;
        private String firstname;
        private String lastname;
        private Account accounts ;
        
        public Builder(String memId)
        {
            this.memId = memId;
        }

        public Builder() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
                
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }
        public Builder member(Member member)
        {
            this.accounts = member.getAccounts();
            this.firstname= member.getFirstname();
            this.id       = member.getId();
            this.lastname= member.getLastname();
            this.memId  =member.getMemId();
            
            return this;
        }
        
        public Builder account(Account accounts)
        {
            this.accounts = accounts;
            return this;
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

    public Account getAccounts() {
        return accounts;
    }

    public Long getId() {
        return id;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Member other = (Member) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
     
}
