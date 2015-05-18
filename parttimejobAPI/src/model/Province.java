package model;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Province entity. @author MyEclipse Persistence Tools
 */

public class Province  implements java.io.Serializable {


    // Fields    

     private Long code;
     private String name;
     private Set cities = new HashSet(0);
     private Set userInfos = new HashSet(0);
     private Set colleges = new HashSet(0);


    // Constructors

    /** default constructor */
    public Province() {
    }

	/** minimal constructor */
    public Province(Long code, String name) {
        this.code = code;
        this.name = name;
    }
    
    /** full constructor */
    public Province(Long code, String name, Set cities, Set userInfos, Set colleges) {
        this.code = code;
        this.name = name;
        this.cities = cities;
        this.userInfos = userInfos;
        this.colleges = colleges;
    }

   
    // Property accessors

    public Long getCode() {
        return this.code;
    }
    
    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getCities() {
        return this.cities;
    }
    
    public void setCities(Set cities) {
        this.cities = cities;
    }

    public Set getUserInfos() {
        return this.userInfos;
    }
    
    public void setUserInfos(Set userInfos) {
        this.userInfos = userInfos;
    }

    public Set getColleges() {
        return this.colleges;
    }
    
    public void setColleges(Set colleges) {
        this.colleges = colleges;
    }
   








}