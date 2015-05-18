package model;
// default package



/**
 * UserSetting entity. @author MyEclipse Persistence Tools
 */

public class UserSetting  implements java.io.Serializable {


    // Fields    

     private Long userid;
     private UserAccount userAccount;
     private Integer privacy;


    // Constructors

    /** default constructor */
    public UserSetting() {
    }

	/** minimal constructor */
    public UserSetting(Long userid, UserAccount userAccount) {
        this.userid = userid;
        this.userAccount = userAccount;
    }
    
    /** full constructor */
    public UserSetting(Long userid, UserAccount userAccount, Integer privacy) {
        this.userid = userid;
        this.userAccount = userAccount;
        this.privacy = privacy;
    }

   
    // Property accessors

    public Long getUserid() {
        return this.userid;
    }
    
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public UserAccount getUserAccount() {
        return this.userAccount;
    }
    
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Integer getPrivacy() {
        return this.privacy;
    }
    
    public void setPrivacy(Integer privacy) {
        this.privacy = privacy;
    }
   








}