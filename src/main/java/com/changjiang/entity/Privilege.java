package com.changjiang.entity;
public class Privilege {
    private Integer id;
    private String number;
    private String dbDesc;
    private java.util.Date startTime;
    private java.util.Date endTime;
    private String storeName;
    private String priority;
    public Privilege() {
        super();
    }
    public Privilege(Integer id,String number,String dbDesc,java.util.Date startTime,java.util.Date endTime,String storeName,String priority) {
        super();
        this.id = id;
        this.number = number;
        this.dbDesc = dbDesc;
        this.startTime = startTime;
        this.endTime = endTime;
        this.storeName = storeName;
        this.priority = priority;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDbDesc() {
        return this.dbDesc;
    }

    public void setDbDesc(String dbDesc) {
        this.dbDesc = dbDesc;
    }

    public java.util.Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }

    public java.util.Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

}
