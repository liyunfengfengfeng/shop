package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.StoreEvaluationDao;
import com.changjiang.entity.StoreEvaluation;
import com.changjiang.common.Assist;
@Service
public class StoreEvaluationServiceImpl implements StoreEvaluationService{
    @Autowired
	private StoreEvaluationDao storeEvaluationDao;
    @Override
    public long getStoreEvaluationRowCount(Assist assist){
        return storeEvaluationDao.getStoreEvaluationRowCount(assist);
    }
    @Override
    public List<StoreEvaluation> selectStoreEvaluation(Assist assist){
        return storeEvaluationDao.selectStoreEvaluation(assist);
    }
    @Override
    public StoreEvaluation selectStoreEvaluationById(Integer id){
        return storeEvaluationDao.selectStoreEvaluationById(id);
    }
    @Override
    public int insertStoreEvaluation(StoreEvaluation value){
        return storeEvaluationDao.insertStoreEvaluation(value);
    }
    @Override
    public int insertNonEmptyStoreEvaluation(StoreEvaluation value){
        return storeEvaluationDao.insertNonEmptyStoreEvaluation(value);
    }
    @Override
    public int deleteStoreEvaluationById(Integer id){
        return storeEvaluationDao.deleteStoreEvaluationById(id);
    }
    @Override
    public int deleteStoreEvaluation(Assist assist){
        return storeEvaluationDao.deleteStoreEvaluation(assist);
    }
    @Override
    public int updateStoreEvaluationById(StoreEvaluation enti){
        return storeEvaluationDao.updateStoreEvaluationById(enti);
    }
    @Override
    public int updateStoreEvaluation(StoreEvaluation value, Assist assist){
        return storeEvaluationDao.updateStoreEvaluation(value,assist);
    }
    @Override
    public int updateNonEmptyStoreEvaluationById(StoreEvaluation enti){
        return storeEvaluationDao.updateNonEmptyStoreEvaluationById(enti);
    }
    @Override
    public int updateNonEmptyStoreEvaluation(StoreEvaluation value, Assist assist){
        return storeEvaluationDao.updateNonEmptyStoreEvaluation(value,assist);
    }

    public StoreEvaluationDao getStoreEvaluationDao() {
        return this.storeEvaluationDao;
    }

    public void setStoreEvaluationDao(StoreEvaluationDao storeEvaluationDao) {
        this.storeEvaluationDao = storeEvaluationDao;
    }

}