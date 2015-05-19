package model;
// default package



/**
 * EnterpriseInfo entity. @author MyEclipse Persistence Tools
 */

public class EnterpriseInfo  implements java.io.Serializable {


    // Fields    

     private Long enterpriseid;
     private EnterpriseAccount enterpriseAccount;
     private String account;
     private Integer sex;
     private String remark;
     private String img;
     private String company;
     private String email;
     private String qq;


    // Constructors

    /** default constructor */
    public EnterpriseInfo() {
    }

	/** minimal constructor */
    public EnterpriseInfo(Long enterpriseid, EnterpriseAccount enterpriseAccount) {
        this.enterpriseid = enterpriseid;
        this.enterpriseAccount = enterpriseAccount;
    }
    
    /** full constructor */
    public EnterpriseInfo(Long enterpriseid, EnterpriseAccount enterpriseAccount, String account, Integer sex, String remark, String img, String company,String email,String qq,String name) {
        this.enterpriseid = enterpriseid;
        this.enterpriseAccount = enterpriseAccount;
        this.account = account;
        this.sex = sex;
        this.remark = remark;
        this.img = img;
        this.company = company;
        this.email = email;
        this.qq = qq;
    }

   
    // Property accessors

    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Long getEnterpriseid() {
        return this.enterpriseid;
    }
    
    public void setEnterpriseid(Long enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    public EnterpriseAccount getEnterpriseAccount() {
        return this.enterpriseAccount;
    }
    
    public void setEnterpriseAccount(EnterpriseAccount enterpriseAccount) {
        this.enterpriseAccount = enterpriseAccount;
    }

    public String getAccount() {
        return this.account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImg() {
        return this.img;
    }
    
    public void setImg(String img) {
        this.img = img;
    }

    public String getCompany() {
        return this.company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
   








}