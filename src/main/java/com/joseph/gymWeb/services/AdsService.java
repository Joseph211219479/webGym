/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.services;

import com.joseph.gymWeb.domain.Ads;
import com.joseph.gymWeb.domain.Supplier;
import java.util.List;

/**
 *
 * @author Common Sense
 */
public interface AdsService {
    public List<Ads> listall ();
    public List<Ads> supplierssAds(Supplier supplier);
    
}
