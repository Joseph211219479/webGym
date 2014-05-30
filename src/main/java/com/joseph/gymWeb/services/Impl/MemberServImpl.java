/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.services.Impl;

import com.joseph.gymWeb.domain.Member;
import com.joseph.gymWeb.repository.MemberRepo;
import com.joseph.gymWeb.services.MemberServ;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Common Sense
 */
@Service
public class MemberServImpl implements MemberServ{
    @Autowired
    private MemberRepo repo;
    
    @Override
    public List<Member> memberList() 
    {
        List<Member>listall = repo.findAll();
        return listall;
    }

    @Override
    public Member searchByID(String memID) {
        List<Member>listall = repo.findAll();
        Member mem = null;
        
        for(Member m : listall)
        {
            if(m.getMemId() == memID)
            {
                mem = m;
            }
        }
        return mem;
    }

    @Override
    public List<Member> searchByFullname(String lastname, String firstname) 
    {
        List<Member>listall = repo.findAll();
        List<Member> mem = new ArrayList();
        
        for(Member m : listall)
        {
            if(m.getFirstname() == firstname && m.getLastname()== lastname)
            {
                mem.add(m);
            }
        }
        return mem;
    }
    
    
}
