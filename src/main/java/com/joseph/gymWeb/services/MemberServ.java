/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.services;

import com.joseph.gymWeb.domain.Member;
import java.util.List;

/**
 *
 * @author Common Sense
 */
public interface MemberServ {
    public List<Member> memberList();
    public Member searchByID(String memID);
    public List<Member> searchByFullname(String lastname, String firstname);
    
    
}
