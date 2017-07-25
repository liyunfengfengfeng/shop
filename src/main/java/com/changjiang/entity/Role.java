package com.changjiang.entity;
public class Role {
    private Integer id;
    private String name;
    private String dbDesc;
    private String icon;
    private String state;
    private Integer storeId;
    public Role() {
        super();
    }
    public Role(Integer id,String name,String dbDesc,String icon,String state,Integer storeId) {
        super();
        this.id = id;
        this.name = name;
        this.dbDesc = dbDesc;
        this.icon = icon;
        this.state = state;
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

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

}
