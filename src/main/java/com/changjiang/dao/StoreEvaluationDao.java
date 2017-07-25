package com.changjiang.dao;
import com.changjiang.entity.StoreEvaluation;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface StoreEvaluationDao{
    long getStoreEvaluationRowCount(Assist assist);
    List<StoreEvaluation> selectStoreEvaluation(Assist assist);
    StoreEvaluation selectStoreEvaluationById(Integer id);
    int insertStoreEvaluation(StoreEvaluation value);
    int insertNonEmptyStoreEvaluation(StoreEvaluation value);
    int deleteStoreEvaluationById(Integer id);
    int deleteStoreEvaluation(Assist assist);
    int updateStoreEvaluationById(StoreEvaluation enti);
    int updateStoreEvaluation(@Param("enti") StoreEvaluation value, @Param("assist") Assist assist);
    int updateNonEmptyStoreEvaluationById(StoreEvaluation enti);
    int updateNonEmptyStoreEvaluation(@Param("enti") StoreEvaluation value, @Param("assist") Assist assist);
}