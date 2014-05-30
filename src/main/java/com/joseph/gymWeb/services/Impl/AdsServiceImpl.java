/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.services.Impl;

import com.joseph.gymWeb.domain.Ads;
import com.joseph.gymWeb.domain.Supplier;
import com.joseph.gymWeb.repository.AdsRepo;
import com.joseph.gymWeb.services.AdsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Common Sense
 */
@Service
public class AdsServiceImpl implements AdsService{
    @Autowired
    private AdsRepo repo;
    @Override
    public List<Ads> listall() {
        List<Ads> ads = repo.findAll();
        List<Ads> list = new ArrayList();
        for(Ads a : ads)
        {
            list.add(a);
        }
        
        return list;
    }

    @Override
    public List<Ads> supplierssAds(Supplier supplier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
