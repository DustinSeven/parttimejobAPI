package model;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * EnterpriseAccount entity. @author MyEclipse Persistence Tools
 */

public class EnterpriseAccount  implements java.io.Serializable {


    // Fields    

     private Long enterpriseid;
     private String mobile;
     private String password;
     private Set enterpriseInfos = new HashSet(0);
     private Set jobDetails = new HashSet(0);


    // Constructors

    /** default constructor */
    public EnterpriseAccount() {
    }

    
    /** full constructor */
    public EnterpriseAccount(String mobile, String password, Set enterpriseInfos, Set jobDetails) {
        this.mobile = mobile;
        this.password = password;
        this.enterpriseInfos = enterpriseInfos;
        this.jobDetails = jobDetails;
    }

   
    // Property accessors

    public Long getEnterpriseid() {
        return this.enterpriseid;
    }
    
    public void setEnterpriseid(Long enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Set getEnterpriseInfos() {
        return this.enterpriseInfos;
    }
    
    public void setEnterpriseInfos(Set enterpriseInfos) {
        this.enterpriseInfos = enterpriseInfos;
    }

    public Set getJobDetails() {
        return this.jobDetails;
    }
    
    public void setJobDetails(Set jobDetails) {
        this.jobDetails = jobDetails;
    }
   








}