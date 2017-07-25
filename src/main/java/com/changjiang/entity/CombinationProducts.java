package com.changjiang.entity;
public class CombinationProducts {
    private Integer id;
    private String name;
    private String dbDesc;
    private Double price;
    private Double privilegePrice;
    private Double sumPrice;
    private Integer storeId;
    public CombinationProducts() {
        super();
    }
    public CombinationProducts(Integer id,String name,String dbDesc,Double price,Double privilegePrice,Double sumPrice,Integer storeId) {
        super();
        this.id = id;
        this.name = name;
        this.dbDesc = dbDesc;
        this.price = price;
        this.privilegePrice = privilegePrice;
        this.sumPrice = sumPrice;
        this.storeId = storeId;
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

    public Double getPrivilegePrice() {
        return this.privilegePrice;
    }

    public void setPrivilegePrice(Double privilegePrice) {
        this.privilegePrice = privilegePrice;
    }

    public Double getSumPrice() {
        return this.sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Integer getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

}
