package com.changjiang.dao;
import com.changjiang.entity.RolePower;
import java.util.List;
import com.changjiang.common.Assist;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
public interface RolePowerDao{
    long getRolePowerRowCount(Assist assist);
    List<RolePower> selectRolePower(Assist assist);
    RolePower selectRolePowerById(Integer id);
    int insertRolePower(RolePower value);
    int insertNonEmptyRolePower(RolePower value);
    int deleteRolePowerById(Integer id);
    int deleteRolePower(Assist assist);
    int updateRolePowerById(RolePower enti);
    int updateRolePower(@Param("enti") RolePower value, @Param("assist") Assist assist);
    int updateNonEmptyRolePowerById(RolePower enti);
    int updateNonEmptyRolePower(@Param("enti") RolePower value, @Param("assist") Assist assist);
    @Select("select * from role_power where role_id=#{role_id}")
    @Results({
    	@Result(id=true,column="id",property="id"),
    	@Result(column="role_id",property="roleId"),
    	@Result(column="function_name",property="functionName"),
    	@Result(column="function_id",property="function",
    	one=@One(select="com.changjiang.dao.FunctionDao.selectFunctionById",
    	fetchType=FetchType.EAGER)),
    })
    List<RolePower> selectRolePowerByRoleId(Integer role_id);
}