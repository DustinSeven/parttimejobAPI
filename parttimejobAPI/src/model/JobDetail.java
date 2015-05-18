package model;
// default package

import java.sql.Timestamp;
import java.util.Date;


/**
 * JobDetail entity. @author MyEclipse Persistence Tools
 */

public class JobDetail  implements java.io.Serializable {


    // Fields    

     private Long jobid;
     private PayUnit payUnit;
     private JobType jobType;
     private PayCountType payCountType;
     private String name;
     private String img;
     private EnterpriseAccount enterpriseAccount;
     private Double pay;
     private String time;
     private Date deadline;
     private String address;
     private Integer num;
     private Integer sex;
     private Float height;
     private Integer health;
     private Integer interview;
     private String interviewaddr;
     private String interviewtime;
     private String jobContent;
     private String remark;
     private Integer worktimetype;
     private Double latitude;
     private Double longitude;
     private Timestamp createtime;
     private Integer enable;
     private Integer overdue;
     private Area area;


    // Constructors

    /** default constructor */
     
    public JobDetail() {
    }

	/** full constructor */
    public JobDetail(PayUnit payUnit, JobType jobType, PayCountType payCountType, String name, String img, EnterpriseAccount enterpriseAccount, Double pay, String time, Date deadline, String address, Integer num, Integer sex, Float height, Integer health, Integer interview, String interviewaddr, String interviewtime, String jobContent, String remark, Integer worktimetype, Double latitude, Double longitude, Timestamp createtime, Integer enable, Integer overdue, Area area) {
        this.payUnit = payUnit;
        this.jobType = jobType;
        this.payCountType = payCountType;
        this.name = name;
        this.img = img;
        this.enterpriseAccount = enterpriseAccount;
        this.pay = pay;
        this.time = time;
        this.deadline = deadline;
        this.address = address;
        this.num = num;
        this.sex = sex;
        this.height = height;
        this.health = health;
        this.interview = interview;
        this.interviewaddr = interviewaddr;
        this.interviewtime = interviewtime;
        this.jobContent = jobContent;
        this.remark = remark;
        this.worktimetype = worktimetype;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createtime = createtime;
        this.enable = enable;
        this.overdue = overdue;
        this.area = area;
    }

   
    // Property accessors

    public Long getJobid() {
        return this.jobid;
    }
    
    public void setJobid(Long jobid) {
        this.jobid = jobid;
    }

    public PayUnit getPayUnit() {
        return this.payUnit;
    }
    
    public void setPayUnit(PayUnit payUnit) {
        this.payUnit = payUnit;
    }

    public JobType getJobType() {
        return this.jobType;
    }
    
    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public PayCountType getPayCountType() {
        return this.payCountType;
    }
    
    public void setPayCountType(PayCountType payCountType) {
        this.payCountType = payCountType;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return this.img;
    }
    
    public void setImg(String img) {
        this.img = img;
    }

    public EnterpriseAccount getEnterpriseAccount() {
		return enterpriseAccount;
	}


	public void setEnterpriseAccount(EnterpriseAccount enterpriseAccount) {
		this.enterpriseAccount = enterpriseAccount;
	}


	public Double getPay() {
        return this.pay;
    }
    
    public void setPay(Double pay) {
        this.pay = pay;
    }

    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public Date getDeadline() {
        return this.deadline;
    }
    
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNum() {
        return this.num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Float getHeight() {
        return this.height;
    }
    
    public void setHeight(Float height) {
        this.height = height;
    }

    public Integer getHealth() {
        return this.health;
    }
    
    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getInterview() {
        return this.interview;
    }
    
    public void setInterview(Integer interview) {
        this.interview = interview;
    }

    public String getInterviewaddr() {
        return this.interviewaddr;
    }
    
    public void setInterviewaddr(String interviewaddr) {
        this.interviewaddr = interviewaddr;
    }

    public String getInterviewtime() {
        return this.interviewtime;
    }
    
    public void setInterviewtime(String interviewtime) {
        this.interviewtime = interviewtime;
    }

    public String getJobContent() {
        return this.jobContent;
    }
    
    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getWorktimetype() {
        return this.worktimetype;
    }
    
    public void setWorktimetype(Integer worktimetype) {
        this.worktimetype = worktimetype;
    }

    public Double getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Timestamp getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Integer getEnable() {
        return this.enable;
    }
    
    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getOverdue() {
        return this.overdue;
    }
    
    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }
   
    public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}







}