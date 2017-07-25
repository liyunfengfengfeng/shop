package com.changjiang.entity;

import java.util.List;

public class CounterType {
    private Integer id;
    private String name;
    private String dbDesc;
    private String state;
    //一个类型对应多个柜台
    private List<Counter> counters;
    public CounterType() {
        super();
    }
    public CounterType(Integer id,String name,String dbDesc,String state) {
        super();
        this.id = id;
        this.name = name;
        this.dbDesc = dbDesc;
        this.state = state;
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

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
	public List<Counter> getCounters() {
		return counters;
	}
	public void setCounters(List<Counter> counters) {
		this.counters = counters;
	}

}
