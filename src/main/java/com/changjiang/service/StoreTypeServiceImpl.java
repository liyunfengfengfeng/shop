package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.StoreTypeDao;
import com.changjiang.entity.StoreType;
import com.changjiang.common.Assist;
@Service
public class StoreTypeServiceImpl implements StoreTypeService{
    @Autowired
	private StoreTypeDao storeTypeDao;
    @Override
    public long getStoreTypeRowCount(Assist assist){
        return storeTypeDao.getStoreTypeRowCount(assist);
    }
    @Override
    public List<StoreType> selectStoreType(Assist assist){
        return storeTypeDao.selectStoreType(assist);
    }
    @Override
    public StoreType selectStoreTypeById(Integer id){
        return storeTypeDao.selectStoreTypeById(id);
    }
    @Override
    public int insertStoreType(StoreType value){
        return storeTypeDao.insertStoreType(value);
    }
    @Override
    public int insertNonEmptyStoreType(StoreType value){
        return storeTypeDao.insertNonEmptyStoreType(value);
    }
    @Override
    public int deleteStoreTypeById(Integer id){
        return storeTypeDao.deleteStoreTypeById(id);
    }
    @Override
    public int deleteStoreType(Assist assist){
        return storeTypeDao.deleteStoreType(assist);
    }
    @Override
    public int updateStoreTypeById(StoreType enti){
        return storeTypeDao.updateStoreTypeById(enti);
    }
    @Override
    public int updateStoreType(StoreType value, Assist assist){
        return storeTypeDao.updateStoreType(value,assist);
    }
    @Override
    public int updateNonEmptyStoreTypeById(StoreType enti){
        return storeTypeDao.updateNonEmptyStoreTypeById(enti);
    }
    @Override
    public int updateNonEmptyStoreType(StoreType value, Assist assist){
        return storeTypeDao.updateNonEmptyStoreType(value,assist);
    }

    public StoreTypeDao getStoreTypeDao() {
        return this.storeTypeDao;
    }

    public void setStoreTypeDao(StoreTypeDao storeTypeDao) {
        this.storeTypeDao = storeTypeDao;
    }
    /**
     * 通过店面类型查询所有的店面  嵌套结果: 使用嵌套结果映射来处理重复的联合结果的子集
     * @param id
     * @return
     */
    @Override
    public List<StoreType> getStoresByStoreType(Integer id) {
        return storeTypeDao.getStoresByStoreType(id);
    }
}