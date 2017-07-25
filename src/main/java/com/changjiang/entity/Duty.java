package com.changjiang.entity;

import java.util.List;

/**
 * 
 * 职责
 */
public class Duty {
    private Integer id;
    private String name;
    private String dbDesc;
    private Integer gradeId;
    private Integer storeId;
    private String state;
    private List userInformations;
    public Duty() {
        super();
    }
    public Duty(Integer id,String name,String dbDesc,Integer gradeId,Integer storeId,String state) {
        super();
        this.id = id;
        this.name = name;
        this.dbDesc = dbDesc;
        this.gradeId = gradeId;
        this.storeId = storeId;
        this.state = state;
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

    public Integer getGradeId() {
        return this.gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
	public List getUserInformation() {
		return userInformations;
	}
	public void setUserInformation(List userInformations) {
		this.userInformations = userInformations;
	}

}
