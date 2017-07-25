package com.changjiang.dao;
import com.changjiang.entity.ProducteEvaluation;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface ProducteEvaluationDao{
    long getProducteEvaluationRowCount(Assist assist);
    List<ProducteEvaluation> selectProducteEvaluation(Assist assist);
    ProducteEvaluation selectProducteEvaluationById(Integer id);
    int insertProducteEvaluation(ProducteEvaluation value);
    int insertNonEmptyProducteEvaluation(ProducteEvaluation value);
    int deleteProducteEvaluationById(Integer id);
    int deleteProducteEvaluation(Assist assist);
    int updateProducteEvaluationById(ProducteEvaluation enti);
    int updateProducteEvaluation(@Param("enti") ProducteEvaluation value, @Param("assist") Assist assist);
    int updateNonEmptyProducteEvaluationById(ProducteEvaluation enti);
    int updateNonEmptyProducteEvaluation(@Param("enti") ProducteEvaluation value, @Param("assist") Assist assist);
}