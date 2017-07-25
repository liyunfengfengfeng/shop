package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.Users;
import com.changjiang.common.Assist;
public interface UsersService{
    long getUsersRowCount(Assist assist);
    Users selectUsersById(Integer id);
    int insertUsers(Users value);
    int insertNonEmptyUsers(Users value);
    int deleteUsersById(Integer id);
    int updateUsersById(Users enti);
    int updateUsers(Users value, Assist assist);
    int updateNonEmptyUsersById(Users enti);
    int updateNonEmptyUsers(Users value, Assist assist);
    Users selectUsersHaveAll(Integer id);
    Users login(String username,String password);
    //根据userId，查出用户所在店的所有用户
    List<Users> selectAllUsersByUserId(Integer id);
    //查出所有启用的用户
    List<Users> selectEnabledUsersByUserId(Integer id);
    //查出所有未启用的用户
    List<Users> selectDisabledUsersByUserId(Integer id);
    boolean deleteManyUser(Integer[] users);
}