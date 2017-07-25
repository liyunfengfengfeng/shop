package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.PrivilegeProducteDao;
import com.changjiang.entity.PrivilegeProducte;
import com.changjiang.common.Assist;
@Service
public class PrivilegeProducteServiceImpl implements PrivilegeProducteService{
    @Autowired
	private PrivilegeProducteDao privilegeProducteDao;
    @Override
    public long getPrivilegeProducteRowCount(Assist assist){
        return privilegeProducteDao.getPrivilegeProducteRowCount(assist);
    }
    @Override
    public List<PrivilegeProducte> selectPrivilegeProducte(Assist assist){
        return privilegeProducteDao.selectPrivilegeProducte(assist);
    }
    @Override
    public PrivilegeProducte selectPrivilegeProducteById(Integer id){
        return privilegeProducteDao.selectPrivilegeProducteById(id);
    }
    @Override
    public int insertPrivilegeProducte(PrivilegeProducte value){
        return privilegeProducteDao.insertPrivilegeProducte(value);
    }
    @Override
    public int insertNonEmptyPrivilegeProducte(PrivilegeProducte value){
        return privilegeProducteDao.insertNonEmptyPrivilegeProducte(value);
    }
    @Override
    public int deletePrivilegeProducteById(Integer id){
        return privilegeProducteDao.deletePrivilegeProducteById(id);
    }
    @Override
    public int deletePrivilegeProducte(Assist assist){
        return privilegeProducteDao.deletePrivilegeProducte(assist);
    }
    @Override
    public int updatePrivilegeProducteById(PrivilegeProducte enti){
        return privilegeProducteDao.updatePrivilegeProducteById(enti);
    }
    @Override
    public int updatePrivilegeProducte(PrivilegeProducte value, Assist assist){
        return privilegeProducteDao.updatePrivilegeProducte(value,assist);
    }
    @Override
    public int updateNonEmptyPrivilegeProducteById(PrivilegeProducte enti){
        return privilegeProducteDao.updateNonEmptyPrivilegeProducteById(enti);
    }
    @Override
    public int updateNonEmptyPrivilegeProducte(PrivilegeProducte value, Assist assist){
        return privilegeProducteDao.updateNonEmptyPrivilegeProducte(value,assist);
    }

    public PrivilegeProducteDao getPrivilegeProducteDao() {
        return this.privilegeProducteDao;
    }

    public void setPrivilegeProducteDao(PrivilegeProducteDao privilegeProducteDao) {
        this.privilegeProducteDao = privilegeProducteDao;
    }

}