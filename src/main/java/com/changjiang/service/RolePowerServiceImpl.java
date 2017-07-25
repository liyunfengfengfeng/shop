package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.RolePowerDao;
import com.changjiang.entity.RolePower;
import com.changjiang.common.Assist;
@Service
public class RolePowerServiceImpl implements RolePowerService{
    @Autowired
	private RolePowerDao rolePowerDao;
    @Override
    public long getRolePowerRowCount(Assist assist){
        return rolePowerDao.getRolePowerRowCount(assist);
    }
    @Override
    public List<RolePower> selectRolePower(Assist assist){
        return rolePowerDao.selectRolePower(assist);
    }
    @Override
    public RolePower selectRolePowerById(Integer id){
        return rolePowerDao.selectRolePowerById(id);
    }
    @Override
    public int insertRolePower(RolePower value){
        return rolePowerDao.insertRolePower(value);
    }
    @Override
    public int insertNonEmptyRolePower(RolePower value){
        return rolePowerDao.insertNonEmptyRolePower(value);
    }
    @Override
    public int deleteRolePowerById(Integer id){
        return rolePowerDao.deleteRolePowerById(id);
    }
    @Override
    public int deleteRolePower(Assist assist){
        return rolePowerDao.deleteRolePower(assist);
    }
    @Override
    public int updateRolePowerById(RolePower enti){
        return rolePowerDao.updateRolePowerById(enti);
    }
    @Override
    public int updateRolePower(RolePower value, Assist assist){
        return rolePowerDao.updateRolePower(value,assist);
    }
    @Override
    public int updateNonEmptyRolePowerById(RolePower enti){
        return rolePowerDao.updateNonEmptyRolePowerById(enti);
    }
    @Override
    public int updateNonEmptyRolePower(RolePower value, Assist assist){
        return rolePowerDao.updateNonEmptyRolePower(value,assist);
    }

    public RolePowerDao getRolePowerDao() {
        return this.rolePowerDao;
    }

    public void setRolePowerDao(RolePowerDao rolePowerDao) {
        this.rolePowerDao = rolePowerDao;
    }

}