package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.StoreProducte;
import com.changjiang.common.Assist;
public interface StoreProducteService{
    long getStoreProducteRowCount(Assist assist);
    List<StoreProducte> selectStoreProducte(Assist assist);
    StoreProducte selectStoreProducteById(Integer id);
    int insertStoreProducte(StoreProducte value);
    int insertNonEmptyStoreProducte(StoreProducte value);
    int deleteStoreProducteById(Integer id);
    int deleteStoreProducte(Assist assist);
    int updateStoreProducteById(StoreProducte enti);
    int updateStoreProducte(StoreProducte value, Assist assist);
    int updateNonEmptyStoreProducteById(StoreProducte enti);
    int updateNonEmptyStoreProducte(StoreProducte value, Assist assist);
}