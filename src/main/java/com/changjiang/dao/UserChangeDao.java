package com.changjiang.dao;
import com.changjiang.entity.UserChange;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface UserChangeDao{
    long getUserChangeRowCount(Assist assist);
    List<UserChange> selectUserChange(Assist assist);
    UserChange selectUserChangeById(Integer id);
    int insertUserChange(UserChange value);
    int insertNonEmptyUserChange(UserChange value);
    int deleteUserChangeById(Integer id);
    int deleteUserChange(Assist assist);
    int updateUserChangeById(UserChange enti);
    int updateUserChange(@Param("enti") UserChange value, @Param("assist") Assist assist);
    int updateNonEmptyUserChangeById(UserChange enti);
    int updateNonEmptyUserChange(@Param("enti") UserChange value, @Param("assist") Assist assist);
}