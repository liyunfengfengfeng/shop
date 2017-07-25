package com.changjiang.entity;

import java.util.List;
/**
 * 产品类型
 * @author a1996_000
 *
 */
public class ProducteType {
	//产品类型id
    private Integer id;
    //产品类型名称
    private String name;
    //产品类型描述
    private String dbDesc;
    //产品类型店面编号
    private String storeNumber;
    /**
     * 使用一个List<OfficialTrade>集合属性表示产品类型拥有的官方商品
     */
    List<OfficialTrade> officialTrades;
    /**
     * 使用一个List<StoreProducte>集合属性表示产品类型拥有的店面产品
     */
    List<StoreProducte> storeProductes;
    public ProducteType() {
        super();
    }
    public ProducteType(Integer id,String name,String dbDesc,String storeNumber) {
        super();
        this.id = id;
        this.name = name;
        this.dbDesc = dbDesc;
        this.storeNumber = storeNumber;
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

    public String getStoreNumber() {
        return this.storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }
	public List<OfficialTrade> getOfficialTrades() {
		return officialTrades;
	}
	public void setOfficialTrades(List<OfficialTrade> officialTrades) {
		this.officialTrades = officialTrades;
	}
	public List<StoreProducte> getStoreProductes() {
		return storeProductes;
	}
	public void setStoreProductes(List<StoreProducte> storeProductes) {
		this.storeProductes = storeProductes;
	}

}
