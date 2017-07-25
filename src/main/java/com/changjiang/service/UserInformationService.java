package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.UserInformation;
import com.changjiang.viewModel.UserInformationModel;
import com.changjiang.common.Assist;
public interface UserInformationService{
    long getUserInformationRowCount(Assist assist);
    List<UserInformation> selectUserInformation(Assist assist);
    UserInformation selectUserInformationById(Integer id);
    int insertUserInformation(UserInformation value);
    int insertNonEmptyUserInformation(UserInformation value);
    int deleteUserInformationById(Integer id);
    int deleteUserInformation(Assist assist);
    int updateUserInformationById(UserInformation enti);
    int updateUserInformation(UserInformation value, Assist assist);
    int updateNonEmptyUserInformationById(UserInformation enti);
    int updateNonEmptyUserInformation(UserInformation value, Assist assist);
    /**
	 * 查询用户信息和他的所有评价
	 */
	List<UserInformation> queryUserInformationAndEvaluations(Integer user_information_id);
	//添加用户信息，并且返回这条information的id
	Integer addUserInformation(UserInformationModel model);
	//根据状态来判断显示员工信息
	List<UserInformation> selectUserInformationByStoreIdAndState(Integer id,Integer state);
	boolean deleteManyUserInformation(Integer[] userInformationIds);
	boolean deleteSingleUserInformation(Integer userInformationId);
}