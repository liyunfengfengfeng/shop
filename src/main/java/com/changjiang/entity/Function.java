package com.changjiang.entity;
public class Function {
    private Integer id;
    private String functionName;
    private Integer upperLevelId;
    private Integer currentLevel;
    private String icon;
    private Integer groupId;
    private Integer orderId;
    private String urls;
    public Function() {
        super();
    }
    public Function(Integer id,String functionName,Integer upperLevelId,Integer currentLevel,String icon,Integer groupId,Integer orderId,String urls) {
        super();
        this.id = id;
        this.functionName = functionName;
        this.upperLevelId = upperLevelId;
        this.currentLevel = currentLevel;
        this.icon = icon;
        this.groupId = groupId;
        this.orderId = orderId;
        this.urls = urls;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
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

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUrls() {
        return this.urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

}
