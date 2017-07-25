package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.UserInformationDao;
import com.changjiang.dao.WorkStationDao;
import com.changjiang.entity.UserInformation;
import com.changjiang.entity.WorkStation;
import com.changjiang.viewModel.UserInformationModel;
import com.changjiang.common.Assist;
@Service
public class UserInformationServiceImpl implements UserInformationService{
    @Autowired
	private UserInformationDao userInformationDao;
    @Autowired
    private WorkStationDao workstationDao;
    @Override
    public long getUserInformationRowCount(Assist assist){
        return userInformationDao.getUserInformationRowCount(assist);
    }
    @Override
    public List<UserInformation> selectUserInformation(Assist assist){
        return userInformationDao.selectUserInformation(assist);
    }
    @Override
    public UserInformation selectUserInformationById(Integer id){
        return userInformationDao.selectUserInformationById(id);
    }
    @Override
    public int insertUserInformation(UserInformation value){
        return userInformationDao.insertUserInformation(value);
    }
    @Override
    public int insertNonEmptyUserInformation(UserInformation value){
        return userInformationDao.insertNonEmptyUserInformation(value);
    }
    @Override
    public int deleteUserInformationById(Integer id){
        return userInformationDao.deleteUserInformationById(id);
    }
    @Override
    public int deleteUserInformation(Assist assist){
        return userInformationDao.deleteUserInformation(assist);
    }
    @Override
    public int updateUserInformationById(UserInformation enti){
        return userInformationDao.updateUserInformationById(enti);
    }
    @Override
    public int updateUserInformation(UserInformation value, Assist assist){
        return userInformationDao.updateUserInformation(value,assist);
    }
    @Override
    public int updateNonEmptyUserInformationById(UserInformation enti){
        return userInformationDao.updateNonEmptyUserInformationById(enti);
    }
    @Override
    public int updateNonEmptyUserInformation(UserInformation value, Assist assist){
        return userInformationDao.updateNonEmptyUserInformation(value,assist);
    }

    public UserInformationDao getUserInformationDao() {
        return this.userInformationDao;
    }

    public void setUserInformationDao(UserInformationDao userInformationDao) {
        this.userInformationDao = userInformationDao;
    }
    /**
	 * 查询用户信息和他的所有评价
	 */
	@Override
	public List<UserInformation> queryUserInformationAndEvaluations(Integer user_information_id) {
		List<UserInformation> userInformations = userInformationDao.queryUserInformationAndEvaluations(user_information_id);
		return userInformations;
	}
	//首先向UserInformation表下添加数据，之后对WorkStation进行更改，设置它的user_id为新加的UserInformation
	@Override
	public Integer addUserInformation(UserInformationModel model) {
		UserInformation userInformation=new UserInformation();
		userInformation.setUserInformaton(model);
		userInformationDao.insertNonEmptyUserInformation(userInformation);
		
		Integer id=userInformationDao.selectUserInformationIdByIdNumber(model.getIdNumber());
		WorkStation workStation=new WorkStation();
		workStation.setId(model.getWorkstationId());
		workStation.setUserId(id);
		workstationDao.updateNonEmptyWorkStationById(workStation);
		return id;
	}
	//根据状态返回不同的值
	@Override
	public List<UserInformation> selectUserInformationByStoreIdAndState(Integer id, Integer state) {
		List<UserInformation> result=userInformationDao.selectUserInformation(new Assist(
				Assist.and_eq("user_information.store_id",id.toString()),Assist.and_eq("user_information.state",
						state.toString())));
		return result;
	}
	@Override
	public boolean deleteManyUserInformation(Integer[] userInformationIds) {
		try{
			for(Integer id:userInformationIds){
				userInformationDao.deleteUserInformationById(id);
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean deleteSingleUserInformation(Integer userInformationId) {
		if(userInformationDao.deleteUserInformationById(userInformationId)==1){
			return true;
		}
		return false;
	}

}