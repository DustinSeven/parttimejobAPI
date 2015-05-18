package model;
// default package

import java.sql.Timestamp;


/**
 * UserJobShort entity. @author MyEclipse Persistence Tools
 */

public class UserJobShort  implements java.io.Serializable {


    // Fields    

     private Long userjobid;
     private UserAccount userAccount;
     private JobDate jobDate;
     private Timestamp createtime;
     private int signin;
     


    // Constructors

    public int getSignin() {
		return signin;
	}


	public void setSignin(int signin) {
		this.signin = signin;
	}


	/** default constructor */
    public UserJobShort() {
    }

    
    /** full constructor */
    public UserJobShort(UserAccount userAccount, JobDate jobDate, Timestamp createtime) {
        this.userAccount = userAccount;
        this.jobDate = jobDate;
        this.createtime = createtime;
    }

   
    // Property accessors

    public Long getUserjobid() {
        return this.userjobid;
    }
    
    public void setUserjobid(Long userjobid) {
        this.userjobid = userjobid;
    }

    public UserAccount getUserAccount() {
        return this.userAccount;
    }
    
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public JobDate getJobDate() {
        return this.jobDate;
    }
    
    public void setJobDate(JobDate jobDate) {
        this.jobDate = jobDate;
    }

    public Timestamp getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
   








}