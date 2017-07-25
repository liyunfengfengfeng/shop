package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.CombinationProductsRecord;
import com.changjiang.common.Assist;
public interface CombinationProductsRecordService{
    long getCombinationProductsRecordRowCount(Assist assist);
    List<CombinationProductsRecord> selectCombinationProductsRecord(Assist assist);
    CombinationProductsRecord selectCombinationProductsRecordById(Integer id);
    int insertCombinationProductsRecord(CombinationProductsRecord value);
    int insertNonEmptyCombinationProductsRecord(CombinationProductsRecord value);
    int deleteCombinationProductsRecordById(Integer id);
    int deleteCombinationProductsRecord(Assist assist);
    int updateCombinationProductsRecordById(CombinationProductsRecord enti);
    int updateCombinationProductsRecord(CombinationProductsRecord value, Assist assist);
    int updateNonEmptyCombinationProductsRecordById(CombinationProductsRecord enti);
    int updateNonEmptyCombinationProductsRecord(CombinationProductsRecord value, Assist assist);
}