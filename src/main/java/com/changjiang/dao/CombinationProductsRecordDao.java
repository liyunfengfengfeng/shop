package com.changjiang.dao;
import com.changjiang.entity.CombinationProductsRecord;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface CombinationProductsRecordDao{
    long getCombinationProductsRecordRowCount(Assist assist);
    List<CombinationProductsRecord> selectCombinationProductsRecord(Assist assist);
    CombinationProductsRecord selectCombinationProductsRecordById(Integer id);
    int insertCombinationProductsRecord(CombinationProductsRecord value);
    int insertNonEmptyCombinationProductsRecord(CombinationProductsRecord value);
    int deleteCombinationProductsRecordById(Integer id);
    int deleteCombinationProductsRecord(Assist assist);
    int updateCombinationProductsRecordById(CombinationProductsRecord enti);
    int updateCombinationProductsRecord(@Param("enti") CombinationProductsRecord value, @Param("assist") Assist assist);
    int updateNonEmptyCombinationProductsRecordById(CombinationProductsRecord enti);
    int updateNonEmptyCombinationProductsRecord(@Param("enti") CombinationProductsRecord value, @Param("assist") Assist assist);
}