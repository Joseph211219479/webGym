/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.repository;

import com.joseph.gymWeb.domain.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Common Sense
 */
@Repository
public interface PayrollRepo extends JpaRepository<Payroll,Long>{
    
}
