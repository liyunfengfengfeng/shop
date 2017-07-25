package com.changjiang.entity;

import java.util.List;

public class Department {
    private Integer id;
    private String number;
    private String name;
    private String dbDesc;
    private Integer storeId;
    private String departmentGrade;
    //对应多个工作岗位
    List<WorkStation> workStations;
    public Department() {
        super();
    }
    public Department(Integer id,String number,String name,String dbDesc,Integer storeId,String departmentGrade) {
        super();
        this.id = id;
        this.number = number;
        this.name = name;
        this.dbDesc = dbDesc;
        this.storeId = storeId;
        this.departmentGrade = departmentGrade;
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

    public Integer getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getDepartmentGrade() {
        return this.departmentGrade;
    }

    public void setDepartmentGrade(String departmentGrade) {
        this.departmentGrade = departmentGrade;
    }
	public List<WorkStation> getWorkStations() {
		return workStations;
	}
	public void setWorkStations(List<WorkStation> workStations) {
		this.workStations = workStations;
	}

}
