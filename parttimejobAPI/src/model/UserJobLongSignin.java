package model;
// default package

import java.sql.Timestamp;


/**
 * UserJobLongSignin entity. @author MyEclipse Persistence Tools
 */

public class UserJobLongSignin  implements java.io.Serializable {


    // Fields    

     private Long id;
     private JobDetail jobDetail;
     private UserAccount userAccount;
     private Timestamp createtime;


    // Constructors

    /** default constructor */
    public UserJobLongSignin() {
    }

    
    /** full constructor */
    public UserJobLongSignin(JobDetail jobDetail, UserAccount userAccount, Timestamp createtime) {
        this.jobDetail = jobDetail;
        this.userAccount = userAccount;
        this.createtime = createtime;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public JobDetail getJobDetail() {
        return this.jobDetail;
    }
    
    public void setJobDetail(JobDetail jobDetail) {
        this.jobDetail = jobDetail;
    }

    public UserAccount getUserAccount() {
        return this.userAccount;
    }
    
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Timestamp getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
   








}