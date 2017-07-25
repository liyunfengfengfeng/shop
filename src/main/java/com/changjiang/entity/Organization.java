package com.changjiang.entity;
public class Organization {
    private Integer id;
    private String name;
    private Integer upperLevelId;
    private Integer currentLevel;
    public Organization() {
        super();
    }
    public Organization(Integer id,String name,Integer upperLevelId,Integer currentLevel) {
        super();
        this.id = id;
        this.name = name;
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
