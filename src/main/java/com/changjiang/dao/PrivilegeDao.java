package com.changjiang.dao;
import com.changjiang.entity.Privilege;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface PrivilegeDao{
    long getPrivilegeRowCount(Assist assist);
    List<Privilege> selectPrivilege(Assist assist);
    Privilege selectPrivilegeById(Integer id);
    int insertPrivilege(Privilege value);
    int insertNonEmptyPrivilege(Privilege value);
    int deletePrivilegeById(Integer id);
    int deletePrivilege(Assist assist);
    int updatePrivilegeById(Privilege enti);
    int updatePrivilege(@Param("enti") Privilege value, @Param("assist") Assist assist);
    int updateNonEmptyPrivilegeById(Privilege enti);
    int updateNonEmptyPrivilege(@Param("enti") Privilege value, @Param("assist") Assist assist);
}