package com.changjiang.entity;

import java.util.List;

public class StoreType {
    private Integer id;
    private String storeTypeName;
    private String state;
    private String dbExplain;
    /**
     * 使用一个List<Store>集合属性表示店面类型拥有的店面
     */
    private List<Store> stores;
    public StoreType() {
        super();
    }
    public StoreType(Integer id,String storeTypeName,String state,String dbExplain) {
        super();
        this.id = id;
        this.storeTypeName = storeTypeName;
        this.state = state;
        this.dbExplain = dbExplain;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreTypeName() {
        return this.storeTypeName;
    }

    public void setStoreTypeName(String storeTypeName) {
        this.storeTypeName = storeTypeName;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDbExplain() {
        return this.dbExplain;
    }

    public void setDbExplain(String dbExplain) {
        this.dbExplain = dbExplain;
    }
	public List<Store> getStores() {
		return stores;
	}
	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

}
