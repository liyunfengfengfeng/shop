package com.changjiang.entity;
public class DutyRecord {
    private Integer id;
    private String name;
    private String dbDesc;
    private Integer gradeId;
    private String state;
    private Integer officialUserinformation;
    public DutyRecord() {
        super();
    }
    public DutyRecord(Integer id,String name,String dbDesc,Integer gradeId,String state,Integer officialUserinformation) {
        super();
        this.id = id;
        this.name = name;
        this.dbDesc = dbDesc;
        this.gradeId = gradeId;
        this.state = state;
        this.officialUserinformation = officialUserinformation;
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

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getOfficialUserinformation() {
        return this.officialUserinformation;
    }

    public void setOfficialUserinformation(Integer officialUserinformation) {
        this.officialUserinformation = officialUserinformation;
    }

}
