package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.RolePower;
import com.changjiang.common.Assist;
public interface RolePowerService{
    long getRolePowerRowCount(Assist assist);
    List<RolePower> selectRolePower(Assist assist);
    RolePower selectRolePowerById(Integer id);
    int insertRolePower(RolePower value);
    int insertNonEmptyRolePower(RolePower value);
    int deleteRolePowerById(Integer id);
    int deleteRolePower(Assist assist);
    int updateRolePowerById(RolePower enti);
    int updateRolePower(RolePower value, Assist assist);
    int updateNonEmptyRolePowerById(RolePower enti);
    int updateNonEmptyRolePower(RolePower value, Assist assist);
}