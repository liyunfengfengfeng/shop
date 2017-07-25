package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.StoreEvaluation;
import com.changjiang.common.Assist;
public interface StoreEvaluationService{
    long getStoreEvaluationRowCount(Assist assist);
    List<StoreEvaluation> selectStoreEvaluation(Assist assist);
    StoreEvaluation selectStoreEvaluationById(Integer id);
    int insertStoreEvaluation(StoreEvaluation value);
    int insertNonEmptyStoreEvaluation(StoreEvaluation value);
    int deleteStoreEvaluationById(Integer id);
    int deleteStoreEvaluation(Assist assist);
    int updateStoreEvaluationById(StoreEvaluation enti);
    int updateStoreEvaluation(StoreEvaluation value, Assist assist);
    int updateNonEmptyStoreEvaluationById(StoreEvaluation enti);
    int updateNonEmptyStoreEvaluation(StoreEvaluation value, Assist assist);
}