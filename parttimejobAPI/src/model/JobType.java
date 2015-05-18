package model;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * JobType entity. @author MyEclipse Persistence Tools
 */

public class JobType  implements java.io.Serializable {


    // Fields    

     private Long jobtypeid;
     private String name;
     private Set jobDetails = new HashSet(0);


    // Constructors

    /** default constructor */
    public JobType() {
    }

	/** minimal constructor */
    public JobType(Long jobtypeid) {
        this.jobtypeid = jobtypeid;
    }
    
    /** full constructor */
    public JobType(Long jobtypeid, String name, Set jobDetails) {
        this.jobtypeid = jobtypeid;
        this.name = name;
        this.jobDetails = jobDetails;
    }

   
    // Property accessors

    public Long getJobtypeid() {
        return this.jobtypeid;
    }
    
    public void setJobtypeid(Long jobtypeid) {
        this.jobtypeid = jobtypeid;
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