package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.ProducteEvaluation;
import com.changjiang.common.Assist;
public interface ProducteEvaluationService{
    long getProducteEvaluationRowCount(Assist assist);
    List<ProducteEvaluation> selectProducteEvaluation(Assist assist);
    ProducteEvaluation selectProducteEvaluationById(Integer id);
    int insertProducteEvaluation(ProducteEvaluation value);
    int insertNonEmptyProducteEvaluation(ProducteEvaluation value);
    int deleteProducteEvaluationById(Integer id);
    int deleteProducteEvaluation(Assist assist);
    int updateProducteEvaluationById(ProducteEvaluation enti);
    int updateProducteEvaluation(ProducteEvaluation value, Assist assist);
    int updateNonEmptyProducteEvaluationById(ProducteEvaluation enti);
    int updateNonEmptyProducteEvaluation(ProducteEvaluation value, Assist assist);
}