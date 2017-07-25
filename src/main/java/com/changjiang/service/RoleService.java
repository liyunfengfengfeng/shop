package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.Role;
import com.changjiang.common.Assist;
public interface RoleService{
    long getRoleRowCount(Assist assist);
    List<Role> selectRole(String id);
    Role selectRoleById(Integer id);
    int insertRole(Role value);
    int insertNonEmptyRole(Role value);
    int deleteRoleById(Integer id);
    int deleteRole(Assist assist);
    int updateRoleById(Role enti);
    int updateRole(Role value, Assist assist);
    int updateNonEmptyRoleById(Role enti);
    int updateNonEmptyRole(Role value, Assist assist);
    List<Role> selectEnabledRole(String storeId);
    List<Role> selectDisabledRole(String storeId);
    boolean deleteManyRole(Integer[] roles);
}