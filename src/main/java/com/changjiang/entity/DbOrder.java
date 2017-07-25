package com.changjiang.entity;
public class DbOrder {
    private Integer id;
    private String number;
    private Integer typeId;
    private java.util.Date orderTime;
    private java.util.Date checkoutTime;
    private Double receivables;
    private Double paidinAccount;
    private Integer reminderNumber;
    private Integer operatorId;
    private Integer vipId;
    private Integer oneBillForAllId;
    private String storeNumber;
    private Integer timeManageId;
    private Integer orderId;
    private java.util.Date startCounterTime;
    private java.util.Date stopCounterTime;
    private java.util.Date oneForAllTime;
    private java.util.Date mergeCounterTime;
    private String mergeCounterSign;
    private Integer mergeCounterId;
    private String state;
    private String sequence;
    public DbOrder() {
        super();
    }
    public DbOrder(Integer id,String number,Integer typeId,java.util.Date orderTime,java.util.Date checkoutTime,Double receivables,Double paidinAccount,Integer reminderNumber,Integer operatorId,Integer vipId,Integer oneBillForAllId,String storeNumber,Integer timeManageId,Integer orderId,java.util.Date startCounterTime,java.util.Date stopCounterTime,java.util.Date oneForAllTime,java.util.Date mergeCounterTime,String mergeCounterSign,Integer mergeCounterId,String state,String sequence) {
        super();
        this.id = id;
        this.number = number;
        this.typeId = typeId;
        this.orderTime = orderTime;
        this.checkoutTime = checkoutTime;
        this.receivables = receivables;
        this.paidinAccount = paidinAccount;
        this.reminderNumber = reminderNumber;
        this.operatorId = operatorId;
        this.vipId = vipId;
        this.oneBillForAllId = oneBillForAllId;
        this.storeNumber = storeNumber;
        this.timeManageId = timeManageId;
        this.orderId = orderId;
        this.startCounterTime = startCounterTime;
        this.stopCounterTime = stopCounterTime;
        this.oneForAllTime = oneForAllTime;
        this.mergeCounterTime = mergeCounterTime;
        this.mergeCounterSign = mergeCounterSign;
        this.mergeCounterId = mergeCounterId;
        this.state = state;
        this.sequence = sequence;
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

    public Integer getTimeManageId() {
        return this.timeManageId;
    }

    public void setTimeManageId(Integer timeManageId) {
        this.timeManageId = timeManageId;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public java.util.Date getStartCounterTime() {
        return this.startCounterTime;
    }

    public void setStartCounterTime(java.util.Date startCounterTime) {
        this.startCounterTime = startCounterTime;
    }

    public java.util.Date getStopCounterTime() {
        return this.stopCounterTime;
    }

    public void setStopCounterTime(java.util.Date stopCounterTime) {
        this.stopCounterTime = stopCounterTime;
    }

    public java.util.Date getOneForAllTime() {
        return this.oneForAllTime;
    }

    public void setOneForAllTime(java.util.Date oneForAllTime) {
        this.oneForAllTime = oneForAllTime;
    }

    public java.util.Date getMergeCounterTime() {
        return this.mergeCounterTime;
    }

    public void setMergeCounterTime(java.util.Date mergeCounterTime) {
        this.mergeCounterTime = mergeCounterTime;
    }

    public String getMergeCounterSign() {
        return this.mergeCounterSign;
    }

    public void setMergeCounterSign(String mergeCounterSign) {
        this.mergeCounterSign = mergeCounterSign;
    }

    public Integer getMergeCounterId() {
        return this.mergeCounterId;
    }

    public void setMergeCounterId(Integer mergeCounterId) {
        this.mergeCounterId = mergeCounterId;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSequence() {
        return this.sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

}
