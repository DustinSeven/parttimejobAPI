package model;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * College entity. @author MyEclipse Persistence Tools
 */

public class College  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Province province;
     private String name;
     private Set userInfos = new HashSet(0);
     private Set schools = new HashSet(0);


    // Constructors

    /** default constructor */
    public College() {
    }

	/** minimal constructor */
    public College(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public College(Long id, Province province, String name, Set userInfos, Set schools) {
        this.id = id;
        this.province = province;
        this.name = name;
        this.userInfos = userInfos;
        this.schools = schools;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
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

    public Set getSchools() {
        return this.schools;
    }
    
    public void setSchools(Set schools) {
        this.schools = schools;
    }
   








}