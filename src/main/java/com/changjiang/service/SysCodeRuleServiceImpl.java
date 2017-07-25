package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.common.Assist;
import com.changjiang.dao.SysCodeRuleDao;
import com.changjiang.entity.SysCodeRule;
@Service
public class SysCodeRuleServiceImpl implements SysCodeRuleService{
	@Autowired
    private SysCodeRuleDao sysCodeRuleDao;
    @Override
    public long getSysCodeRuleRowCount(Assist assist){
        return sysCodeRuleDao.getSysCodeRuleRowCount(assist);
    }
    @Override
    public List<SysCodeRule> selectSysCodeRule(Assist assist){
        return sysCodeRuleDao.selectSysCodeRule(assist);
    }
    @Override
    public SysCodeRule selectSysCodeRuleById(Integer id){
        return sysCodeRuleDao.selectSysCodeRuleById(id);
    }
    @Override
    public int insertSysCodeRule(SysCodeRule value){
        return sysCodeRuleDao.insertSysCodeRule(value);
    }
    @Override
    public int insertNonEmptySysCodeRule(SysCodeRule value){
        return sysCodeRuleDao.insertNonEmptySysCodeRule(value);
    }
    @Override
    public int deleteSysCodeRuleById(Integer id){
        return sysCodeRuleDao.deleteSysCodeRuleById(id);
    }
    @Override
    public int deleteSysCodeRule(Assist assist){
        return sysCodeRuleDao.deleteSysCodeRule(assist);
    }
    @Override
    public int updateSysCodeRuleById(SysCodeRule enti){
        return sysCodeRuleDao.updateSysCodeRuleById(enti);
    }
    @Override
    public int updateSysCodeRule(SysCodeRule value, Assist assist){
        return sysCodeRuleDao.updateSysCodeRule(value,assist);
    }
    @Override
    public int updateNonEmptySysCodeRuleById(SysCodeRule enti){
        return sysCodeRuleDao.updateNonEmptySysCodeRuleById(enti);
    }
    @Override
    public int updateNonEmptySysCodeRule(SysCodeRule value, Assist assist){
        return sysCodeRuleDao.updateNonEmptySysCodeRule(value,assist);
    }

    public SysCodeRuleDao getSysCodeRuleDao() {
        return this.sysCodeRuleDao;
    }

    public void setSysCodeRuleDao(SysCodeRuleDao sysCodeRuleDao) {
        this.sysCodeRuleDao = sysCodeRuleDao;
    }

}