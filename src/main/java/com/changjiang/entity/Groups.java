package com.changjiang.entity;
public class Groups {
    private Integer id;
    private String groupName;
    private String dbDesc;
    public Groups() {
        super();
    }
    public Groups(Integer id,String groupName,String dbDesc) {
        super();
        this.id = id;
        this.groupName = groupName;
        this.dbDesc = dbDesc;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDbDesc() {
        return this.dbDesc;
    }

    public void setDbDesc(String dbDesc) {
        this.dbDesc = dbDesc;
    }

}
