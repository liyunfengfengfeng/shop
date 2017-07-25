package com.changjiang.entity;
public class Service {
    private Integer id;
    private String number;
    private String dbDesc;
    private Double price;
    private String storeNumber;
    private Integer state;
    private Integer serviceType;
    public Service() {
        super();
    }
    public Service(Integer id,String number,String dbDesc,Double price,String storeNumber,Integer state,Integer serviceType) {
        super();
        this.id = id;
        this.number = number;
        this.dbDesc = dbDesc;
        this.price = price;
        this.storeNumber = storeNumber;
        this.state = state;
        this.serviceType = serviceType;
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

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStoreNumber() {
        return this.storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

}
