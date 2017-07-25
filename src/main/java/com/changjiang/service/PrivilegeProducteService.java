package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.PrivilegeProducte;
import com.changjiang.common.Assist;
public interface PrivilegeProducteService{
    long getPrivilegeProducteRowCount(Assist assist);
    List<PrivilegeProducte> selectPrivilegeProducte(Assist assist);
    PrivilegeProducte selectPrivilegeProducteById(Integer id);
    int insertPrivilegeProducte(PrivilegeProducte value);
    int insertNonEmptyPrivilegeProducte(PrivilegeProducte value);
    int deletePrivilegeProducteById(Integer id);
    int deletePrivilegeProducte(Assist assist);
    int updatePrivilegeProducteById(PrivilegeProducte enti);
    int updatePrivilegeProducte(PrivilegeProducte value, Assist assist);
    int updateNonEmptyPrivilegeProducteById(PrivilegeProducte enti);
    int updateNonEmptyPrivilegeProducte(PrivilegeProducte value, Assist assist);
}