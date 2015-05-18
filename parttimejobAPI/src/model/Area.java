package model;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Area entity. @author MyEclipse Persistence Tools
 */

public class Area  implements java.io.Serializable {


    // Fields    

     private Long code;
     private City city;
     private String name;
     private Set userInfos = new HashSet(0);
     private Set jobDetails = new HashSet(0);


    // Constructors

    /** default constructor */
    public Area() {
    }

	/** minimal constructor */
    public Area(Long code) {
        this.code = code;
    }
    
    /** full constructor */
    public Area(Long code, City city, String name, Set userInfos,Set jobDetails) {
        this.code = code;
        this.city = city;
        this.name = name;
        this.userInfos = userInfos;
        this.jobDetails = jobDetails;
    }

   
    // Property accessors

    public Long getCode() {
        return this.code;
    }
    
    public void setCode(Long code) {
        this.code = code;
    }

    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getUserInfos() {
        return this.userInfos;
    }
    
    public void setUserInfos(Set userInfos) {
        this.userInfos = userInfos;
    }

	public Set getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(Set jobDetails) {
		this.jobDetails = jobDetails;
	}
   








}