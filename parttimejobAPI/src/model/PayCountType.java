package model;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * PayCountType entity. @author MyEclipse Persistence Tools
 */

public class PayCountType  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private Set jobDetails = new HashSet(0);


    // Constructors

    /** default constructor */
    public PayCountType() {
    }

	/** minimal constructor */
    public PayCountType(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public PayCountType(Long id, String name, Set jobDetails) {
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