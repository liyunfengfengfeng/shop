package com.changjiang.entity;
public class StoreProducte {
    private Integer id;
    private String name;
    private String dbDesc;
    private String video;
    private String rawMaterial;
    private Double price;
    private Integer privilege;
    private Integer officialTrade;
    private Integer type;
    private Integer storeId;
    public StoreProducte() {
        super();
    }
    public StoreProducte(Integer id,String name,String dbDesc,String video,String rawMaterial,Double price,Integer privilege,Integer officialTrade,Integer type,Integer storeId) {
        super();
        this.id = id;
        this.name = name;
        this.dbDesc = dbDesc;
        this.video = video;
        this.rawMaterial = rawMaterial;
        this.price = price;
        this.privilege = privilege;
        this.officialTrade = officialTrade;
        this.type = type;
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

    public String getVideo() {
        return this.video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getRawMaterial() {
        return this.rawMaterial;
    }

    public void setRawMaterial(String rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPrivilege() {
        return this.privilege;
    }

    public void setPrivilege(Integer privilege) {
        this.privilege = privilege;
    }

    public Integer getOfficialTrade() {
        return this.officialTrade;
    }

    public void setOfficialTrade(Integer officialTrade) {
        this.officialTrade = officialTrade;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

}
