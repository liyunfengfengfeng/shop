package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.StoreDao;
import com.changjiang.entity.Store;
import com.changjiang.entity.StoreProducte;
import com.changjiang.common.Assist;
@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
	private StoreDao storeDao;
    @Override
    public long getStoreRowCount(Assist assist){
        return storeDao.getStoreRowCount(assist);
    }
    @Override
    public List<Store> selectStore(Assist assist){
        return storeDao.selectStore(assist);
    }
    @Override
    public Store selectStoreById(Integer id){
        return storeDao.selectStoreById(id);
    }
    @Override
    public int insertStore(Store value){
        return storeDao.insertStore(value);
    }
    @Override
    public int insertNonEmptyStore(Store value){
        return storeDao.insertNonEmptyStore(value);
    }
    @Override
    public int deleteStoreById(Integer id){
        return storeDao.deleteStoreById(id);
    }
    @Override
    public int deleteStore(Assist assist){
        return storeDao.deleteStore(assist);
    }
    @Override
    public int updateStoreById(Store enti){
        return storeDao.updateStoreById(enti);
    }
    @Override
    public int updateStore(Store value, Assist assist){
        return storeDao.updateStore(value,assist);
    }
    @Override
    public int updateNonEmptyStoreById(Store enti){
        return storeDao.updateNonEmptyStoreById(enti);
    }
    @Override
    public int updateNonEmptyStore(Store value, Assist assist){
        return storeDao.updateNonEmptyStore(value,assist);
    }

    public StoreDao getStoreDao() {
        return this.storeDao;
    }

    public void setStoreDao(StoreDao storeDao) {
        this.storeDao = storeDao;
    }
    /**
     * 通过店面id查询店面具有的所有产品
     * @param storeid
     * @return
     */
	@Override
	public List<StoreProducte> queryStoreProducteByStoreId(Integer storeid) {
		Store store = storeDao.queryStoreProducteByStoreId(storeid);
		List<StoreProducte> storeProductes = store.getStoreProducte();
		return storeProductes;
	}
	@Override
	public Integer selectStoreIdByStoreNumber(String storeNumber) {
		Integer id=storeDao.selectIdByStoreNumber(storeNumber);
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public List<Store> selectEnabledStoreByOrganizationId(Integer id) {
		List<Store> stores=storeDao.selectEnabledStoreByOrganizationId(id);
		// TODO Auto-generated method stub
		return stores;
	}

}