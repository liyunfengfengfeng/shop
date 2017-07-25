package com.changjiang.entity;
public class ServiceType {
    private Integer id;
    private String number;
    private String name;
    private String dbDesc;
    private Integer state;
    private String storeNumber;
    public ServiceType() {
        super();
    }
    public ServiceType(Integer id,String number,String name,String dbDesc,Integer state,String storeNumber) {
        super();
        this.id = id;
        this.number = number;
        this.name = name;
        this.dbDesc = dbDesc;
        this.state = state;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDbDesc() {
        return this.dbDesc;
    }

    public void setDbDesc(String dbDesc) {
        this.dbDesc = dbDesc;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStoreNumber() {
        return this.storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

}
