package com.changjiang.entity;
public class GroupMembers {
    private Integer id;
    private String username;
    private Integer userId;
    private Integer groupId;
    public GroupMembers() {
        super();
    }
    public GroupMembers(Integer id,String username,Integer userId,Integer groupId) {
        super();
        this.id = id;
        this.username = username;
        this.userId = userId;
        this.groupId = groupId;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

}
