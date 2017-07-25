package com.changjiang.entity;
public class Area {
    private Integer id;
    private String name;
    private Integer store;
    private String state;
    private String dbDesc;
    private Integer upperLevelId;
    private Integer currentLevel;
    public Area() {
        super();
    }
    public Area(Integer id,String name,Integer store,String state,String dbDesc,Integer upperLevelId,Integer currentLevel) {
        super();
        this.id = id;
        this.name = name;
        this.store = store;
        this.state = state;
        this.dbDesc = dbDesc;
        this.upperLevelId = upperLevelId;
        this.currentLevel = currentLevel;
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

    public Integer getStore() {
        return this.store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDbDesc() {
        return this.dbDesc;
    }

    public void setDbDesc(String dbDesc) {
        this.dbDesc = dbDesc;
    }

    public Integer getUpperLevelId() {
        return this.upperLevelId;
    }

    public void setUpperLevelId(Integer upperLevelId) {
        this.upperLevelId = upperLevelId;
    }

    public Integer getCurrentLevel() {
        return this.currentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }

}
