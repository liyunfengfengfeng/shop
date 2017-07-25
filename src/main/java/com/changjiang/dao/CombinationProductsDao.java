package com.changjiang.dao;
import com.changjiang.entity.CombinationProducts;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface CombinationProductsDao{
    long getCombinationProductsRowCount(Assist assist);
    List<CombinationProducts> selectCombinationProducts(Assist assist);
    CombinationProducts selectCombinationProductsById(Integer id);
    int insertCombinationProducts(CombinationProducts value);
    int insertNonEmptyCombinationProducts(CombinationProducts value);
    int deleteCombinationProductsById(Integer id);
    int deleteCombinationProducts(Assist assist);
    int updateCombinationProductsById(CombinationProducts enti);
    int updateCombinationProducts(@Param("enti") CombinationProducts value, @Param("assist") Assist assist);
    int updateNonEmptyCombinationProductsById(CombinationProducts enti);
    int updateNonEmptyCombinationProducts(@Param("enti") CombinationProducts value, @Param("assist") Assist assist);
}