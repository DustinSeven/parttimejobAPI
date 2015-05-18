package model;
// default package



/**
 * Advice entity. @author MyEclipse Persistence Tools
 */

public class Advice  implements java.io.Serializable {


    // Fields    

     private Long id;
     private UserAccount userAccount;
     private String content;


    // Constructors

    /** default constructor */
    public Advice() {
    }

    
    /** full constructor */
    public Advice(UserAccount userAccount, String content) {
        this.userAccount = userAccount;
        this.content = content;
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

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
   








}