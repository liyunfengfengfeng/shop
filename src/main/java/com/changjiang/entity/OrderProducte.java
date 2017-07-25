package com.changjiang.entity;
public class OrderProducte {
    private Integer id;
    private String name;
    private Integer orderId;
    private Integer producteId;
    private Integer number;
    private Double price;
    private Integer serviceId;
    private String note;
    private java.util.Date readyFinishTime;
    private java.util.Date makeFinishTime;
    private java.util.Date sendFinishTime;
    private Integer reminderNumber;
    public OrderProducte() {
        super();
    }
    public OrderProducte(Integer id,String name,Integer orderId,Integer producteId,Integer number,Double price,Integer serviceId,String note,java.util.Date readyFinishTime,java.util.Date makeFinishTime,java.util.Date sendFinishTime,Integer reminderNumber) {
        super();
        this.id = id;
        this.name = name;
        this.orderId = orderId;
        this.producteId = producteId;
        this.number = number;
        this.price = price;
        this.serviceId = serviceId;
        this.note = note;
        this.readyFinishTime = readyFinishTime;
        this.makeFinishTime = makeFinishTime;
        this.sendFinishTime = sendFinishTime;
        this.reminderNumber = reminderNumber;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProducteId() {
        return this.producteId;
    }

    public void setProducteId(Integer producteId) {
        this.producteId = producteId;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public java.util.Date getReadyFinishTime() {
        return this.readyFinishTime;
    }

    public void setReadyFinishTime(java.util.Date readyFinishTime) {
        this.readyFinishTime = readyFinishTime;
    }

    public java.util.Date getMakeFinishTime() {
        return this.makeFinishTime;
    }

    public void setMakeFinishTime(java.util.Date makeFinishTime) {
        this.makeFinishTime = makeFinishTime;
    }

    public java.util.Date getSendFinishTime() {
        return this.sendFinishTime;
    }

    public void setSendFinishTime(java.util.Date sendFinishTime) {
        this.sendFinishTime = sendFinishTime;
    }

    public Integer getReminderNumber() {
        return this.reminderNumber;
    }

    public void setReminderNumber(Integer reminderNumber) {
        this.reminderNumber = reminderNumber;
    }

}
