package com.changjiang.entity;
public class OfficialTrade {
    private Integer id;
    private String number;
    private String officialName;
    private String productName;
    private String alias;
    private Integer officialType;
    private String formerName;
    private String dbDesc;
    private Double officialPrice;
    private String icon;
    private String video;
    private Integer statisticalCategories;
    private String rawMaterial;
    public OfficialTrade() {
        super();
    }
    public OfficialTrade(Integer id,String number,String officialName,String productName,String alias,Integer officialType,String formerName,String dbDesc,Double officialPrice,String icon,String video,Integer statisticalCategories,String rawMaterial) {
        super();
        this.id = id;
        this.number = number;
        this.officialName = officialName;
        this.productName = productName;
        this.alias = alias;
        this.officialType = officialType;
        this.formerName = formerName;
        this.dbDesc = dbDesc;
        this.officialPrice = officialPrice;
        this.icon = icon;
        this.video = video;
        this.statisticalCategories = statisticalCategories;
        this.rawMaterial = rawMaterial;
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

    public String getOfficialName() {
        return this.officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getOfficialType() {
        return this.officialType;
    }

    public void setOfficialType(Integer officialType) {
        this.officialType = officialType;
    }

    public String getFormerName() {
        return this.formerName;
    }

    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }

    public String getDbDesc() {
        return this.dbDesc;
    }

    public void setDbDesc(String dbDesc) {
        this.dbDesc = dbDesc;
    }

    public Double getOfficialPrice() {
        return this.officialPrice;
    }

    public void setOfficialPrice(Double officialPrice) {
        this.officialPrice = officialPrice;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getVideo() {
        return this.video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Integer getStatisticalCategories() {
        return this.statisticalCategories;
    }

    public void setStatisticalCategories(Integer statisticalCategories) {
        this.statisticalCategories = statisticalCategories;
    }

    public String getRawMaterial() {
        return this.rawMaterial;
    }

    public void setRawMaterial(String rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

}
