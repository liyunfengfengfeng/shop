package com.changjiang.dao;
import com.changjiang.entity.Users;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
public interface UsersDao{
    long getUsersRowCount(Assist assist);
    List<Users> selectUsers(Assist assist);
    Users selectUsersById(Integer id);
    int insertUsers(Users value);
    int insertNonEmptyUsers(Users value);
    int deleteUsersById(Integer id);
    int deleteUsers(Assist assist);
    int updateUsersById(Users enti);
    int updateUsers(@Param("enti") Users value, @Param("assist") Assist assist);
    int updateNonEmptyUsersById(Users enti);
    int updateNonEmptyUsers(@Param("enti") Users value, @Param("assist") Assist assist);
    //关联查询users中的Role和UserInformation
    @Select("SELECT * FROM users WHERE id=#{id}")
    @Results({
    	@Result(id=true,column="id",property="id"),
    	@Result(column="username",property="username"),
    	@Result(column="password",property="password"),
    	@Result(column="role_id",property="role",
    	one=@One(select="com.changjiang.dao.RoleDao.selectRoleById",
    	fetchType=FetchType.EAGER)),
    	@Result(column="store",property="store"),
    	@Result(column="user_information",property="user",
    	one=@One(select="com.changjiang.dao.UserInformationDao."
    			+ "selectUserInformationById",fetchType=FetchType.EAGER))
    })
    Users selectSingleUserHaveAll(Integer id);
    //根据店铺的编号来查找user
    @Select("SELECT * FROM users WHERE store=#{number}")
    @Results({
    	@Result(id=true,column="id",property="id"),
    	@Result(column="username",property="username"),
    	@Result(column="password",property="password"),
    	@Result(column="role_id",property="role",
    	one=@One(select="com.changjiang.dao.RoleDao.selectRoleById",
    	fetchType=FetchType.EAGER)),
    	@Result(column="store",property="store"),
    	@Result(column="user_information",property="user",
    	one=@One(select="com.changjiang.dao.UserInformationDao."
    			+ "selectUserInformationById",fetchType=FetchType.EAGER))
    })
    List<Users> selectAllUsersHaveAllByStoreNumber(String number);
    //根据店铺的编号查出启用的user
    @Select("SELECT * FROM users WHERE store=#{number} AND enabled=0")
    @Results({
    	@Result(id=true,column="id",property="id"),
    	@Result(column="username",property="username"),
    	@Result(column="password",property="password"),
    	@Result(column="role_id",property="role",
    	one=@One(select="com.changjiang.dao.RoleDao.selectRoleById",
    	fetchType=FetchType.EAGER)),
    	@Result(column="store",property="store"),
    	@Result(column="user_information",property="userInformation")
    })
    List<Users> selectEnabledUsersHaveAllByStoreNumber(String number);
    //根据店铺的编号查出未启用的user
    @Select("SELECT * FROM users WHERE store=#{number} AND enabled=1")
    @Results({
    	@Result(id=true,column="id",property="id"),
    	@Result(column="username",property="username"),
    	@Result(column="password",property="password"),
    	@Result(column="role_id",property="role",
    	one=@One(select="com.changjiang.dao.RoleDao.selectRoleById",
    	fetchType=FetchType.EAGER)),
    	@Result(column="store",property="store"),
    	@Result(column="user_information",property="userInformation")
    })
    List<Users> selectDisabledUsersHaveAllByStoreNumber(String number);
}