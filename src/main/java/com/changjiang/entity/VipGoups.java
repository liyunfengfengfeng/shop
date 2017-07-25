package com.changjiang.entity;

import java.util.List;

/**
 * 会员组信息
 */
public class VipGoups {
	//会员组id
    private Integer id;
    //编号
    private String number;
    //名称
    private String name;
    //描述
    private String dbDesc;
    //折扣
    private Integer discount;
    //所属店面编号
    private Integer storeNumber;
    //状态
    private String state;
    //会员组所包含的会员
    private List<Vip> vips;
    public VipGoups() {
        super();
    }
    public VipGoups(Integer id,String number,String name,String dbDesc,Integer discount,Integer storeNumber,String state) {
        super();
        this.id = id;
        this.number = number;
        this.name = name;
        this.dbDesc = dbDesc;
        this.discount = discount;
        this.storeNumber = storeNumber;
        this.state = state;
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

    public Integer getDiscount() {
        return this.discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getStoreNumber() {
        return this.storeNumber;
    }

    public void setStoreNumber(Integer storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
	public List<Vip> getVips() {
		return vips;
	}
	public void setVips(List<Vip> vips) {
		this.vips = vips;
	}

}
