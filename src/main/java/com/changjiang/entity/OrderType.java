package com.changjiang.entity;

import java.util.List;

/**
 * 
 * 订单类型 
 */
public class OrderType {
	/**
	 * 订单类型 id
	 */
    private Integer id;
    /**
     * 订单类型 编号
     */
    private String number;
    /**
     * 订单类型 名称
     */
    private String name;
    /**
     * 订单类型 描述
     */
    private String dbDesc;
    /**
     * 订单类型 店面编号
     */
    private String storeNumber;
    /**
     * 订单类型 状态
     */
    private String state;
    /**
     * 一种订单类型对应多个订单
     */
    List<Order> orders;
    
    public OrderType() {
        super();
    }
    public OrderType(Integer id,String number,String name,String dbDesc,String storeNumber,String state) {
        super();
        this.id = id;
        this.number = number;
        this.name = name;
        this.dbDesc = dbDesc;
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

    public String getStoreNumber() {
        return this.storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
