package com.changjiang.entity;

import java.util.List;

public class Store {
    private Integer id;
    private String name;
    private Integer storeTypeId;
    private String address;
    private String phone;
    private String legalName;
    private String legalNamePhone;
    private String state;
    private String dbDesc;
    private Integer organizationId;
    private String number;
    //该店面所具有的商品
    List<StoreProducte> storeProducte;
    public Store() {
        super();
    }
    public Store(Integer id,String name,Integer storeTypeId,String address,String phone,String legalName,String legalNamePhone,String state,String dbDesc,Integer organizationId,String number) {
        super();
        this.id = id;
        this.name = name;
        this.storeTypeId = storeTypeId;
        this.address = address;
        this.phone = phone;
        this.legalName = legalName;
        this.legalNamePhone = legalNamePhone;
        this.state = state;
        this.dbDesc = dbDesc;
        this.organizationId = organizationId;
        this.number = number;
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

    public Integer getStoreTypeId() {
        return this.storeTypeId;
    }

    public void setStoreTypeId(Integer storeTypeId) {
        this.storeTypeId = storeTypeId;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLegalName() {
        return this.legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getLegalNamePhone() {
        return this.legalNamePhone;
    }

    public void setLegalNamePhone(String legalNamePhone) {
        this.legalNamePhone = legalNamePhone;
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

    public Integer getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
	public List<StoreProducte> getStoreProducte() {
		return storeProducte;
	}
	public void setStoreProducte(List<StoreProducte> storeProducte) {
		this.storeProducte = storeProducte;
	}

}
