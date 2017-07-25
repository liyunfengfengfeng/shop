package com.changjiang.dao;
import com.changjiang.entity.UserEvaluation;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface UserEvaluationDao{
    long getUserEvaluationRowCount(Assist assist);
    List<UserEvaluation> selectUserEvaluation(Assist assist);
    UserEvaluation selectUserEvaluationById(Integer id);
    int insertUserEvaluation(UserEvaluation value);
    int insertNonEmptyUserEvaluation(UserEvaluation value);
    int deleteUserEvaluationById(Integer id);
    int deleteUserEvaluation(Assist assist);
    int updateUserEvaluationById(UserEvaluation enti);
    int updateUserEvaluation(@Param("enti") UserEvaluation value, @Param("assist") Assist assist);
    int updateNonEmptyUserEvaluationById(UserEvaluation enti);
    int updateNonEmptyUserEvaluation(@Param("enti") UserEvaluation value, @Param("assist") Assist assist);
}