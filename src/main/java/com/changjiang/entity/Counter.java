package com.changjiang.entity;

import java.util.List;

public class Counter {
    private Integer id;
    private String name;
    private String dbDesc;
    private Integer type;
    private Integer store;
    private String state;
    private Integer area;
    //一个柜台对应多个柜台岗位记录
    List<CounterWorkStationRecord> counterWorkStationRecords;
    public Counter() {
        super();
    }
    public Counter(Integer id,String name,String dbDesc,Integer type,Integer store,String state,Integer area) {
        super();
        this.id = id;
        this.name = name;
        this.dbDesc = dbDesc;
        this.type = type;
        this.store = store;
        this.state = state;
        this.area = area;
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

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getArea() {
        return this.area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
	public List<CounterWorkStationRecord> getCounterWorkStationRecords() {
		return counterWorkStationRecords;
	}
	public void setCounterWorkStationRecords(List<CounterWorkStationRecord> counterWorkStationRecords) {
		this.counterWorkStationRecords = counterWorkStationRecords;
	}

}
