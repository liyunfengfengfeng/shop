package com.changjiang.entity;
public class OfficialProducteSpeciality {
    private Integer id;
    private String name;
    private String dbDesc;
    private Integer storeProducte;
    private Integer officialProducte;
    private String degree;
    public OfficialProducteSpeciality() {
        super();
    }
    public OfficialProducteSpeciality(Integer id,String name,String dbDesc,Integer storeProducte,Integer officialProducte,String degree) {
        super();
        this.id = id;
        this.name = name;
        this.dbDesc = dbDesc;
        this.storeProducte = storeProducte;
        this.officialProducte = officialProducte;
        this.degree = degree;
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

}
