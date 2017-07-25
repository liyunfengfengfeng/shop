package com.changjiang.dao;
import com.changjiang.entity.UserInformation;
import java.util.List;
import com.changjiang.common.Assist;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
public interface UserInformationDao{
    long getUserInformationRowCount(Assist assist);
    List<UserInformation> selectUserInformation(Assist assist);
    UserInformation selectUserInformationById(Integer id);
    int insertUserInformation(UserInformation value);
    int insertNonEmptyUserInformation(UserInformation value);
    int deleteUserInformationById(Integer id);
    int deleteUserInformation(Assist assist);
    int updateUserInformationById(UserInformation enti);
    int updateUserInformation(@Param("enti") UserInformation value, @Param("assist") Assist assist);
    int updateNonEmptyUserInformationById(UserInformation enti);
    int updateNonEmptyUserInformation(@Param("enti") UserInformation value, @Param("assist") Assist assist);
    /**
	 * 查询用户信息和他的所有评价
	 */
    List<UserInformation> queryUserInformationAndEvaluations(Integer user_information_id);
    @Select("SELECT id from user_information WHERE id_number=#{IdNumber}")
    @Results({
    	@Result(id=true,column="id",property="id")
    })
    Integer selectUserInformationIdByIdNumber(String IdNumber);
    /**
	 * 通过id查询userInformation与其对应的workstation
	 * @param id
	 * @return
	 */
    List<UserInformation> findUserInformationAndWorkStation(Integer id);
    @Select("SELECT * FROM user_information WHERE user_information.id=#{id}")
    @Results({
    	@Result(id=true,column="id",property="id"),
    	@Result(column="realname",property="realname"),
    	@Result(id=true,column="id_number",property="idNumber"),
    	@Result(column="phone",property="phone"),
    	@Result(column="db_desc",property="dbDesc"),
    	@Result(column="sex",property="sex"),
    	@Result(column="icon",property="icon"),
    	@Result(column="address",property="address"),
    	@Result(column="qq",property="qq"),
    	@Result(column="wechat",property="wechat"),
    	@Result(column="email",property="email"),
    	@Result(column="state",property="state"),
    	@Result(column="duty_id",property="duty",
    			one=@One(select="com.changjiang.dao.DutyDao."
    	    			+ "selectDutyById",fetchType=FetchType.EAGER)),
    	@Result(column="department_id",property="departmentId",
    			one=@One(select="com.changjiang.dao.DepartmentDao.selectDepartmentById",
    			fetchType=FetchType.EAGER))
    })
    UserInformation selectUserInformationHaveAllById(Integer id);
    @Select("SELECT * FROM user_information WHERE store.id=#{storeId}")
    @Results({
    	@Result(id=true,column="id",property="id"),
    	@Result(column="realname",property="realname"),
    	@Result(id=true,column="id_number",property="idNumber"),
    	@Result(column="phone",property="phone"),
    	@Result(column="db_desc",property="dbDesc"),
    	@Result(column="sex",property="sex"),
    	@Result(column="icon",property="icon"),
    	@Result(column="address",property="address"),
    	@Result(column="qq",property="qq"),
    	@Result(column="wechat",property="wechat"),
    	@Result(column="email",property="email"),
    	@Result(column="state",property="state"),
    	@Result(column="duty_id",property="duty",
    			one=@One(select="com.changjiang.dao.DutyDao."
    	    			+ "selectDutyById",fetchType=FetchType.EAGER)),
    	@Result(column="department_id",property="departmentId",
    			one=@One(select="com.changjiang.dao.DepartmentDao.selectDepartmentById",
    			fetchType=FetchType.EAGER))
    })
    List<UserInformation> selectAllUserInformationHaveAll(Integer storeId);
}