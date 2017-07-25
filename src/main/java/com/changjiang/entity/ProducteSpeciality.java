package com.changjiang.entity;
public class ProducteSpeciality {
    private Integer id;
    private String name;
    private String dbDesc;
    private String storeNumber;
    private Integer storeProducte;
    private Integer officialProducte;
    private String degree;
    private Integer officialSpecial;
    public ProducteSpeciality() {
        super();
    }
    public ProducteSpeciality(Integer id,String name,String dbDesc,String storeNumber,Integer storeProducte,Integer officialProducte,String degree,Integer officialSpecial) {
        super();
        this.id = id;
        this.name = name;
        this.dbDesc = dbDesc;
        this.storeNumber = storeNumber;
        this.storeProducte = storeProducte;
        this.officialProducte = officialProducte;
        this.degree = degree;
        this.officialSpecial = officialSpecial;
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

    public String getStoreNumber() {
        return this.storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public Integer getStoreProducte() {
        return this.storeProducte;
    }

    public void setStoreProducte(Integer storeProducte) {
        this.storeProducte = storeProducte;
    }

    public Integer getOfficialProducte() {
        return this.officialProducte;
    }

    public void setOfficialProducte(Integer officialProducte) {
        this.officialProducte = officialProducte;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Integer getOfficialSpecial() {
        return this.officialSpecial;
    }

    public void setOfficialSpecial(Integer officialSpecial) {
        this.officialSpecial = officialSpecial;
    }

}
