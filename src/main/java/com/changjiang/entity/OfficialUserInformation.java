package com.changjiang.entity;
public class OfficialUserInformation {
    private Integer id;
    private String realname;
    private String idNumber;
    private String phone;
    private String dbDesc;
    private String sex;
    private String icon;
    private String address;
    private String qq;
    private String wechat;
    private String email;
    private String state;
    public OfficialUserInformation() {
        super();
    }
    public OfficialUserInformation(Integer id,String realname,String idNumber,String phone,String dbDesc,String sex,String icon,String address,String qq,String wechat,String email,String state) {
        super();
        this.id = id;
        this.realname = realname;
        this.idNumber = idNumber;
        this.phone = phone;
        this.dbDesc = dbDesc;
        this.sex = sex;
        this.icon = icon;
        this.address = address;
        this.qq = qq;
        this.wechat = wechat;
        this.email = email;
        this.state = state;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return this.realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDbDesc() {
        return this.dbDesc;
    }

    public void setDbDesc(String dbDesc) {
        this.dbDesc = dbDesc;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
