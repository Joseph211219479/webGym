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
public class Ads implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String startdate;
    private String endDate;
    
    private Ads(){}
    private Ads(Build build)
    {
        this.endDate = build.endDate;
        this.startdate = build.startdate;
        this.id = build.id;
    }
    
    public static class Build
    {
        private Long id;
        private String startdate;
        private String endDate;
    
        public Build(Long id)
        {
            this.id = id;
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

    @Override
    public String toString() {
        return "Ads{" + "id=" + id + '}';
    }
    
    
    
}
