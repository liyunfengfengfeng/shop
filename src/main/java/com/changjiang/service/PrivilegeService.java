package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.Privilege;
import com.changjiang.common.Assist;
public interface PrivilegeService{
    long getPrivilegeRowCount(Assist assist);
    List<Privilege> selectPrivilege(Assist assist);
    Privilege selectPrivilegeById(Integer id);
    int insertPrivilege(Privilege value);
    int insertNonEmptyPrivilege(Privilege value);
    int deletePrivilegeById(Integer id);
    int deletePrivilege(Assist assist);
    int updatePrivilegeById(Privilege enti);
    int updatePrivilege(Privilege value, Assist assist);
    int updateNonEmptyPrivilegeById(Privilege enti);
    int updateNonEmptyPrivilege(Privilege value, Assist assist);
}