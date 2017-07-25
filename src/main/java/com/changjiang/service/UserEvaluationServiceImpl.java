package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.UserEvaluationDao;
import com.changjiang.entity.UserEvaluation;
import com.changjiang.common.Assist;
@Service
public class UserEvaluationServiceImpl implements UserEvaluationService{
    @Autowired
	private UserEvaluationDao userEvaluationDao;
    @Override
    public long getUserEvaluationRowCount(Assist assist){
        return userEvaluationDao.getUserEvaluationRowCount(assist);
    }
    @Override
    public List<UserEvaluation> selectUserEvaluation(Assist assist){
        return userEvaluationDao.selectUserEvaluation(assist);
    }
    @Override
    public UserEvaluation selectUserEvaluationById(Integer id){
        return userEvaluationDao.selectUserEvaluationById(id);
    }
    @Override
    public int insertUserEvaluation(UserEvaluation value){
        return userEvaluationDao.insertUserEvaluation(value);
    }
    @Override
    public int insertNonEmptyUserEvaluation(UserEvaluation value){
        return userEvaluationDao.insertNonEmptyUserEvaluation(value);
    }
    @Override
    public int deleteUserEvaluationById(Integer id){
        return userEvaluationDao.deleteUserEvaluationById(id);
    }
    @Override
    public int deleteUserEvaluation(Assist assist){
        return userEvaluationDao.deleteUserEvaluation(assist);
    }
    @Override
    public int updateUserEvaluationById(UserEvaluation enti){
        return userEvaluationDao.updateUserEvaluationById(enti);
    }
    @Override
    public int updateUserEvaluation(UserEvaluation value, Assist assist){
        return userEvaluationDao.updateUserEvaluation(value,assist);
    }
    @Override
    public int updateNonEmptyUserEvaluationById(UserEvaluation enti){
        return userEvaluationDao.updateNonEmptyUserEvaluationById(enti);
    }
    @Override
    public int updateNonEmptyUserEvaluation(UserEvaluation value, Assist assist){
        return userEvaluationDao.updateNonEmptyUserEvaluation(value,assist);
    }

    public UserEvaluationDao getUserEvaluationDao() {
        return this.userEvaluationDao;
    }

    public void setUserEvaluationDao(UserEvaluationDao userEvaluationDao) {
        this.userEvaluationDao = userEvaluationDao;
    }

}