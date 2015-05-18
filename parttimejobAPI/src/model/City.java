package model;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * City entity. @author MyEclipse Persistence Tools
 */

public class City  implements java.io.Serializable {


    // Fields    

     private Long code;
     private Province province;
     private String name;
     private Set userInfos = new HashSet(0);
     private Set areas = new HashSet(0);


    // Constructors

    /** default constructor */
    public City() {
    }

	/** minimal constructor */
    public City(Long code, Province province, String name) {
        this.code = code;
        this.province = province;
        this.name = name;
    }
    
    /** full constructor */
    public City(Long code, Province province, String name, Set userInfos, Set areas) {
        this.code = code;
        this.province = province;
        this.name = name;
        this.userInfos = userInfos;
        this.areas = areas;
    }

   
    // Property accessors

    public Long getCode() {
        return this.code;
    }
    
    public void setCode(Long code) {
        this.code = code;
    }

    public Province getProvince() {
        return this.province;
    }
    
    public void setProvince(Province province) {
        this.province = province;
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

    public Set getAreas() {
        return this.areas;
    }
    
    public void setAreas(Set areas) {
        this.areas = areas;
    }
   








}