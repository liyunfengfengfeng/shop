package com.changjiang.entity;

import java.util.List;

import com.changjiang.viewModel.UserInformationModel;

/**
 * 
 * 用户信息表
 *
 */
public class UserInformation {
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
    private Integer dutyId;
    private Duty duty;
    private Department department;
    private Integer departmentId;
	private String state;
    private Integer storeId;
    //一个用户对应多个评价
    List<UserEvaluation> userEvaluations;
    //一个用户对应多个岗位
    List<WorkStation> workStations;
    public UserInformation() {
        super();
    }
    public Duty getDuty() {
		return duty;
	}
	public void setDuty(Duty duty) {
		this.duty = duty;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
    public UserInformation(Integer id,String realname,String idNumber,String phone,String dbDesc,String sex,String icon,String address,String qq,String wechat,String email,Integer dutyId,Integer departmentId,String state,Integer storeId) {
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
        this.dutyId = dutyId;
        this.departmentId = departmentId;
        this.state = state;
        this.storeId = storeId;
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

    public Integer getDutyId() {
        return this.dutyId;
    }

    public void setDutyId(Integer dutyId) {
        this.dutyId = dutyId;
    }

    public Integer getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
	public List<UserEvaluation> getUserEvaluations() {
		return userEvaluations;
	}
	public void setUserEvaluations(List<UserEvaluation> userEvaluations) {
		this.userEvaluations = userEvaluations;
	}
	public List<WorkStation> getWorkStations() {
		return workStations;
	}
	public void setWorkStations(List<WorkStation> workStations) {
		this.workStations = workStations;
	}
	public void setUserInformaton(UserInformationModel model){
		this.address=model.getAddress();
		this.dbDesc=model.getDbDesc();
		this.departmentId=model.getDepartmentId();
		this.dutyId=model.getDutyId();
		this.email=model.getEmail();
		this.icon=model.getIcon();
		this.idNumber=model.getIdNumber();
		this.phone=model.getPhone();
		this.qq=model.getQq();
		this.realname=model.getRealname();
		this.sex=model.getSex();
		this.storeId=model.getStoreId();
		this.wechat=model.getWechat();
	}
}
