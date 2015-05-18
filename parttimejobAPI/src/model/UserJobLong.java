package model;
// default package

import java.sql.Timestamp;


/**
 * UserJob entity. @author MyEclipse Persistence Tools
 */

public class UserJobLong  implements java.io.Serializable {


    // Fields    

     private Long id;
     private JobDetail jobDetail;
     private UserAccount userAccount;
     private Timestamp createtime;
    // Constructors

	/** default constructor */
    public UserJobLong() {
    }

    
    public JobDetail getJobDetail() {
		return jobDetail;
	}


	public void setJobDetail(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}


	/** full constructor */
    public UserJobLong(JobDetail jobDetail, UserAccount userAccount, Timestamp createtime) {
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