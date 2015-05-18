package model;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * School entity. @author MyEclipse Persistence Tools
 */

public class School  implements java.io.Serializable {


    // Fields    

     private Long id;
     private College college;
     private String name;
     private Set userInfos = new HashSet(0);


    // Constructors

    /** default constructor */
    public School() {
    }

	/** minimal constructor */
    public School(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public School(Long id, College college, String name, Set userInfos) {
        this.id = id;
        this.college = college;
        this.name = name;
        this.userInfos = userInfos;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public College getCollege() {
        return this.college;
    }
    
    public void setCollege(College college) {
        this.college = college;
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
   








}