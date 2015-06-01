package model;
// default package

import java.sql.Timestamp;


/**
 * TSession entity. @author MyEclipse Persistence Tools
 */

public class TSession  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String entermobile;
     private String usermobile;
     private String text;
     private Timestamp createtime;
     private Integer isfromenter;


    // Constructors

    /** default constructor */
    public TSession() {
    }

    
    /** full constructor */
    public TSession(String entermobile, String usermobile, String text, Timestamp createtime, Integer isfromenter) {
        this.entermobile = entermobile;
        this.usermobile = usermobile;
        this.text = text;
        this.createtime = createtime;
        this.isfromenter = isfromenter;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getEntermobile() {
        return this.entermobile;
    }
    
    public void setEntermobile(String entermobile) {
        this.entermobile = entermobile;
    }

    public String getUsermobile() {
        return this.usermobile;
    }
    
    public void setUsermobile(String usermobile) {
        this.usermobile = usermobile;
    }

    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Integer getIsfromenter() {
        return this.isfromenter;
    }
    
    public void setIsfromenter(Integer isfromenter) {
        this.isfromenter = isfromenter;
    }
   








}