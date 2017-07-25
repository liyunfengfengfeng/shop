package com.changjiang.entity;
public class CombinationProductsRecord {
    private Integer id;
    private Integer combinationProductsId;
    private Integer storeProducteId;
    public CombinationProductsRecord() {
        super();
    }
    public CombinationProductsRecord(Integer id,Integer combinationProductsId,Integer storeProducteId) {
        super();
        this.id = id;
        this.combinationProductsId = combinationProductsId;
        this.storeProducteId = storeProducteId;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCombinationProductsId() {
        return this.combinationProductsId;
    }

    public void setCombinationProductsId(Integer combinationProductsId) {
        this.combinationProductsId = combinationProductsId;
    }

    public Integer getStoreProducteId() {
        return this.storeProducteId;
    }

    public void setStoreProducteId(Integer storeProducteId) {
        this.storeProducteId = storeProducteId;
    }

}
