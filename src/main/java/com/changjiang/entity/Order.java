package com.changjiang.entity;
public class Order {
    private Integer id;
    private String number;
    private Integer typeId;
    private Integer counterId;
    private java.util.Date orderTime;
    private java.util.Date checkoutTime;
    private Double receivables;
    private Double paidinAccount;
    private Integer reminderNumber;
    private Integer operatorId;
    private Integer vipId;
    private Integer oneBillForAllId;
    private String storeNumber;
    public Order() {
        super();
    }
    public Order(Integer id,String number,Integer typeId,Integer counterId,java.util.Date orderTime,java.util.Date checkoutTime,Double receivables,Double paidinAccount,Integer reminderNumber,Integer operatorId,Integer vipId,Integer oneBillForAllId,String storeNumber) {
        super();
        this.id = id;
        this.number = number;
        this.typeId = typeId;
        this.counterId = counterId;
        this.orderTime = orderTime;
        this.checkoutTime = checkoutTime;
        this.receivables = receivables;
        this.paidinAccount = paidinAccount;
        this.reminderNumber = reminderNumber;
        this.operatorId = operatorId;
        this.vipId = vipId;
        this.oneBillForAllId = oneBillForAllId;
        this.storeNumber = storeNumber;
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

    public Integer getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getCounterId() {
        return this.counterId;
    }

    public void setCounterId(Integer counterId) {
        this.counterId = counterId;
    }

    public java.util.Date getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(java.util.Date orderTime) {
        this.orderTime = orderTime;
    }

    public java.util.Date getCheckoutTime() {
        return this.checkoutTime;
    }

    public void setCheckoutTime(java.util.Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public Double getReceivables() {
        return this.receivables;
    }

    public void setReceivables(Double receivables) {
        this.receivables = receivables;
    }

    public Double getPaidinAccount() {
        return this.paidinAccount;
    }

    public void setPaidinAccount(Double paidinAccount) {
        this.paidinAccount = paidinAccount;
    }

    public Integer getReminderNumber() {
        return this.reminderNumber;
    }

    public void setReminderNumber(Integer reminderNumber) {
        this.reminderNumber = reminderNumber;
    }

    public Integer getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getVipId() {
        return this.vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public Integer getOneBillForAllId() {
        return this.oneBillForAllId;
    }

    public void setOneBillForAllId(Integer oneBillForAllId) {
        this.oneBillForAllId = oneBillForAllId;
    }

    public String getStoreNumber() {
        return this.storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

}
