/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.gymWeb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author student
 */
@Entity
public class Ads implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String startdate;
    private String endDate;
    private String adsID;
    
    private Ads(){}
    private Ads(Build build)
    {
        this.endDate = build.endDate;
        this.startdate = build.startdate;
        this.id = build.id;
        this.adsID = build.adsID;
    }
    
    public static class Build
    {
        private Long id;
        private String startdate;
        private String endDate;
        private String adsID;
    
        public Build(String adsID)
        {
            this.adsID = adsID;
        }
        public Build id(Long id)
        {
            this.id = id;
            return this;
        }
        public Build startdate(String startdate)
        {
            this.startdate = startdate;
            return this;
        }
        public Build endDate(String endDate)
        {
            this.endDate = endDate;
            return this;
        }
        public Build ads(Ads ads)
        {
            id = ads.getId();
            startdate = ads.getStartdate();
            endDate = ads.getStartdate();
            adsID = ads.getAdsID();
            
            return this;
        }
        public Ads build()
        {
            return new Ads(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getAdsID() {
        return adsID;
    }
    

    @Override
    public String toString() {
        return "Ads{" + "id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Ads other = (Ads) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
