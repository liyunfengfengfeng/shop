package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.UserEvaluation;
import com.changjiang.common.Assist;
public interface UserEvaluationService{
    long getUserEvaluationRowCount(Assist assist);
    List<UserEvaluation> selectUserEvaluation(Assist assist);
    UserEvaluation selectUserEvaluationById(Integer id);
    int insertUserEvaluation(UserEvaluation value);
    int insertNonEmptyUserEvaluation(UserEvaluation value);
    int deleteUserEvaluationById(Integer id);
    int deleteUserEvaluation(Assist assist);
    int updateUserEvaluationById(UserEvaluation enti);
    int updateUserEvaluation(UserEvaluation value, Assist assist);
    int updateNonEmptyUserEvaluationById(UserEvaluation enti);
    int updateNonEmptyUserEvaluation(UserEvaluation value, Assist assist);
}