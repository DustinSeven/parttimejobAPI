package model;
// default package



/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo  implements java.io.Serializable {


    // Fields    

     private Long userid;
     private Province province;
     private School school;
     private UserAccount userAccount;
     private College college;
     private City city;
     private Area area;
     private String account;
     private Integer sex;
     private String remark;
     private String img;
     private String qq;
     private Integer schoolyear;
     private String specialty;
     private Integer age;


    // Constructors

    /** default constructor */
    public UserInfo() {
    }

	/** minimal constructor */
    public UserInfo(Long userid, UserAccount userAccount) {
        this.userid = userid;
        this.userAccount = userAccount;
    }
    
    /** full constructor */
    public UserInfo(Long userid, Province province, School school, UserAccount userAccount, College college, City city, Area area, String account, Integer sex, String remark, String img, String qq, Integer schoolyear, String specialty, Integer age) {
        this.userid = userid;
        this.province = province;
        this.school = school;
        this.userAccount = userAccount;
        this.college = college;
        this.city = city;
        this.area = area;
        this.account = account;
        this.sex = sex;
        this.remark = remark;
        this.img = img;
        this.qq = qq;
        this.schoolyear = schoolyear;
        this.specialty = specialty;
        this.age = age;
    }

   
    // Property accessors

    public Long getUserid() {
        return this.userid;
    }
    
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Province getProvince() {
        return this.province;
    }
    
    public void setProvince(Province province) {
        this.province = province;
    }

    public School getSchool() {
        return this.school;
    }
    
    public void setSchool(School school) {
        this.school = school;
    }

    public UserAccount getUserAccount() {
        return this.userAccount;
    }
    
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public College getCollege() {
        return this.college;
    }
    
    public void setCollege(College college) {
        this.college = college;
    }

    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }

    public Area getArea() {
        return this.area;
    }
    
    public void setArea(Area area) {
        this.area = area;
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

    public String getQq() {
        return this.qq;
    }
    
    public void setQq(String qq) {
        this.qq = qq;
    }

    public Integer getSchoolyear() {
        return this.schoolyear;
    }
    
    public void setSchoolyear(Integer schoolyear) {
        this.schoolyear = schoolyear;
    }

    public String getSpecialty() {
        return this.specialty;
    }
    
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
   








}