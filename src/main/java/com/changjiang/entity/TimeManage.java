package com.changjiang.entity;
public class TimeManage {
    private Integer id;
    private java.util.Date startTime;
    private java.util.Date endTime;
    private String name;
    private Integer storeId;
    private String state;
    private String dbDesc;
    public TimeManage() {
        super();
    }
    public TimeManage(Integer id,java.util.Date startTime,java.util.Date endTime,String name,Integer storeId,String state,String dbDesc) {
        super();
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.storeId = storeId;
        this.state = state;
        this.dbDesc = dbDesc;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDbDesc() {
        return this.dbDesc;
    }

    public void setDbDesc(String dbDesc) {
        this.dbDesc = dbDesc;
    }

}
