package model;
// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * JobDate entity. @author MyEclipse Persistence Tools
 */

public class JobDate  implements java.io.Serializable {


    // Fields    

     private Long jobdateid;
     private JobDetail jobDetail;
     private Timestamp workdate;
     private Timestamp createdate;
     private int num;
     public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}

	private Set userJobShorts = new HashSet(0);


    // Constructors

    /** default constructor */
    public JobDate() {
    }

    
    /** full constructor */
    public JobDate(JobDetail jobDetail, Timestamp workdate, Timestamp createdate, Set userJobShorts) {
        this.jobDetail = jobDetail;
        this.workdate = workdate;
        this.createdate = createdate;
        this.userJobShorts = userJobShorts;
    }

   
    // Property accessors

    public Long getJobdateid() {
        return this.jobdateid;
    }
    
    public void setJobdateid(Long jobdateid) {
        this.jobdateid = jobdateid;
    }

    public JobDetail getJobDetail() {
        return this.jobDetail;
    }
    
    public void setJobDetail(JobDetail jobDetail) {
        this.jobDetail = jobDetail;
    }

    public Timestamp getWorkdate() {
        return this.workdate;
    }
    
    public void setWorkdate(Timestamp workdate) {
        this.workdate = workdate;
    }

    public Timestamp getCreatedate() {
        return this.createdate;
    }
    
    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public Set getUserJobShorts() {
        return this.userJobShorts;
    }
    
    public void setUserJobShorts(Set userJobShorts) {
        this.userJobShorts = userJobShorts;
    }
   








}