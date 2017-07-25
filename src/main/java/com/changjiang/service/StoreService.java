package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.Store;
import com.changjiang.entity.StoreProducte;
import com.changjiang.common.Assist;
public interface StoreService{
    long getStoreRowCount(Assist assist);
    List<Store> selectStore(Assist assist);
    Store selectStoreById(Integer id);
    int insertStore(Store value);
    int insertNonEmptyStore(Store value);
    int deleteStoreById(Integer id);
    int deleteStore(Assist assist);
    int updateStoreById(Store enti);
    int updateStore(Store value, Assist assist);
    int updateNonEmptyStoreById(Store enti);
    int updateNonEmptyStore(Store value, Assist assist);
    /**
     * 通过店面id查询店面具有的所有产品
     * @param storeid
     * @return
     */
	List<StoreProducte> queryStoreProducteByStoreId(Integer storeid);
	Integer selectStoreIdByStoreNumber(String storeNumber);
	List<Store> selectEnabledStoreByOrganizationId(Integer id);
}