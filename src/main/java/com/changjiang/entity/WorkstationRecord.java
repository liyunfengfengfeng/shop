package com.changjiang.entity;
public class WorkstationRecord {
    private Integer id;
    private Integer userId;
    private String userName;
    private String userPhone;
    private java.util.Date goWorkTime;
    private java.util.Date leaveWorkTime;
    private Integer counterId;
    private Integer sonAreaId;
    private java.util.Date workDay;
    private Integer storeId;
    private Integer workStationId;
    private String number;
    public WorkstationRecord() {
        super();
    }
    public WorkstationRecord(Integer id,Integer userId,String userName,String userPhone,java.util.Date goWorkTime,java.util.Date leaveWorkTime,Integer counterId,Integer sonAreaId,java.util.Date workDay,Integer storeId,Integer workStationId,String number) {
        super();
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.goWorkTime = goWorkTime;
        this.leaveWorkTime = leaveWorkTime;
        this.counterId = counterId;
        this.sonAreaId = sonAreaId;
        this.workDay = workDay;
        this.storeId = storeId;
        this.workStationId = workStationId;
        this.number = number;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return this.userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public java.util.Date getGoWorkTime() {
        return this.goWorkTime;
    }

    public void setGoWorkTime(java.util.Date goWorkTime) {
        this.goWorkTime = goWorkTime;
    }

    public java.util.Date getLeaveWorkTime() {
        return this.leaveWorkTime;
    }

    public void setLeaveWorkTime(java.util.Date leaveWorkTime) {
        this.leaveWorkTime = leaveWorkTime;
    }

    public Integer getCounterId() {
        return this.counterId;
    }

    public void setCounterId(Integer counterId) {
        this.counterId = counterId;
    }

    public Integer getSonAreaId() {
        return this.sonAreaId;
    }

    public void setSonAreaId(Integer sonAreaId) {
        this.sonAreaId = sonAreaId;
    }

    public java.util.Date getWorkDay() {
        return this.workDay;
    }

    public void setWorkDay(java.util.Date workDay) {
        this.workDay = workDay;
    }

    public Integer getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getWorkStationId() {
        return this.workStationId;
    }

    public void setWorkStationId(Integer workStationId) {
        this.workStationId = workStationId;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
