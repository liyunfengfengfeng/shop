package com.changjiang.service;
import java.util.List;
import com.changjiang.dao.CombinationProductsRecordDao;
import com.changjiang.entity.CombinationProductsRecord;
import com.changjiang.common.Assist;
public class CombinationProductsRecordServiceImpl implements CombinationProductsRecordService{
    private CombinationProductsRecordDao combinationProductsRecordDao;
    @Override
    public long getCombinationProductsRecordRowCount(Assist assist){
        return combinationProductsRecordDao.getCombinationProductsRecordRowCount(assist);
    }
    @Override
    public List<CombinationProductsRecord> selectCombinationProductsRecord(Assist assist){
        return combinationProductsRecordDao.selectCombinationProductsRecord(assist);
    }
    @Override
    public CombinationProductsRecord selectCombinationProductsRecordById(Integer id){
        return combinationProductsRecordDao.selectCombinationProductsRecordById(id);
    }
    @Override
    public int insertCombinationProductsRecord(CombinationProductsRecord value){
        return combinationProductsRecordDao.insertCombinationProductsRecord(value);
    }
    @Override
    public int insertNonEmptyCombinationProductsRecord(CombinationProductsRecord value){
        return combinationProductsRecordDao.insertNonEmptyCombinationProductsRecord(value);
    }
    @Override
    public int deleteCombinationProductsRecordById(Integer id){
        return combinationProductsRecordDao.deleteCombinationProductsRecordById(id);
    }
    @Override
    public int deleteCombinationProductsRecord(Assist assist){
        return combinationProductsRecordDao.deleteCombinationProductsRecord(assist);
    }
    @Override
    public int updateCombinationProductsRecordById(CombinationProductsRecord enti){
        return combinationProductsRecordDao.updateCombinationProductsRecordById(enti);
    }
    @Override
    public int updateCombinationProductsRecord(CombinationProductsRecord value, Assist assist){
        return combinationProductsRecordDao.updateCombinationProductsRecord(value,assist);
    }
    @Override
    public int updateNonEmptyCombinationProductsRecordById(CombinationProductsRecord enti){
        return combinationProductsRecordDao.updateNonEmptyCombinationProductsRecordById(enti);
    }
    @Override
    public int updateNonEmptyCombinationProductsRecord(CombinationProductsRecord value, Assist assist){
        return combinationProductsRecordDao.updateNonEmptyCombinationProductsRecord(value,assist);
    }

    public CombinationProductsRecordDao getCombinationProductsRecordDao() {
        return this.combinationProductsRecordDao;
    }

    public void setCombinationProductsRecordDao(CombinationProductsRecordDao combinationProductsRecordDao) {
        this.combinationProductsRecordDao = combinationProductsRecordDao;
    }

}