package com.changjiang.entity;
public class Vip {
    private Integer id;
    private String number;
    private String password;
    private Integer vipTypeId;
    private String name;
    private String telephone;
    private String gender;
    private String qq;
    private String wechat;
    private String email;
    private String personalizedSignature;
    private Integer storeId;
    private String state;
    private String type;
    private Double score;
    public Vip() {
        super();
    }
    public Vip(Integer id,String number,String password,Integer vipTypeId,String name,String telephone,String gender,String qq,String wechat,String email,String personalizedSignature,Integer storeId,String state,String type,Double score) {
        super();
        this.id = id;
        this.number = number;
        this.password = password;
        this.vipTypeId = vipTypeId;
        this.name = name;
        this.telephone = telephone;
        this.gender = gender;
        this.qq = qq;
        this.wechat = wechat;
        this.email = email;
        this.personalizedSignature = personalizedSignature;
        this.storeId = storeId;
        this.state = state;
        this.type = type;
        this.score = score;
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getVipTypeId() {
        return this.vipTypeId;
    }

    public void setVipTypeId(Integer vipTypeId) {
        this.vipTypeId = vipTypeId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQq() {
        return this.qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return this.wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalizedSignature() {
        return this.personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getScore() {
        return this.score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

}
