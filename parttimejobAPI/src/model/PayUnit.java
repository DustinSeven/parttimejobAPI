package model;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * PayUnit entity. @author MyEclipse Persistence Tools
 */

public class PayUnit  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private Set jobDetails = new HashSet(0);


    // Constructors

    /** default constructor */
    public PayUnit() {
    }

	/** minimal constructor */
    public PayUnit(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public PayUnit(Long id, String name, Set jobDetails) {
        this.id = id;
        this.name = name;
        this.jobDetails = jobDetails;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getJobDetails() {
        return this.jobDetails;
    }
    
    public void setJobDetails(Set jobDetails) {
        this.jobDetails = jobDetails;
    }
   








}