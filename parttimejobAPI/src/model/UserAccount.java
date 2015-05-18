package model;
// default package



/**
 * UserAccount entity. @author MyEclipse Persistence Tools
 */

public class UserAccount  implements java.io.Serializable {


    // Fields    

     private Long userid;
     private String mobile;
     private String password;


    // Constructors

    /** default constructor */
    public UserAccount() {
    }

    
    /** full constructor */
    public UserAccount(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

   
    // Property accessors

    public Long getUserid() {
        return this.userid;
    }
    
    public void setUserid(Long userid) {
        this.userid = userid;
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
   








}