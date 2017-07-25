package com.changjiang.dao;
import com.changjiang.entity.Role;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface RoleDao{
    long getRoleRowCount(Assist assist);
    List<Role> selectRole(Assist assist);
    Role selectRoleById(Integer id);
    int insertRole(Role value);
    int insertNonEmptyRole(Role value);
    int deleteRoleById(Integer id);
    int deleteRole(Assist assist);
    int updateRoleById(Role enti);
    int updateRole(@Param("enti") Role value, @Param("assist") Assist assist);
    int updateNonEmptyRoleById(Role enti);
    int updateNonEmptyRole(@Param("enti") Role value, @Param("assist") Assist assist);
}