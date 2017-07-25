package com.changjiang.dao;
import com.changjiang.entity.StoreProducte;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface StoreProducteDao{
    long getStoreProducteRowCount(Assist assist);
    List<StoreProducte> selectStoreProducte(Assist assist);
    StoreProducte selectStoreProducteById(Integer id);
    int insertStoreProducte(StoreProducte value);
    int insertNonEmptyStoreProducte(StoreProducte value);
    int deleteStoreProducteById(Integer id);
    int deleteStoreProducte(Assist assist);
    int updateStoreProducteById(StoreProducte enti);
    int updateStoreProducte(@Param("enti") StoreProducte value, @Param("assist") Assist assist);
    int updateNonEmptyStoreProducteById(StoreProducte enti);
    int updateNonEmptyStoreProducte(@Param("enti") StoreProducte value, @Param("assist") Assist assist);
}