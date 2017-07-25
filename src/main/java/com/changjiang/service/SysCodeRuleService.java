package com.changjiang.service;
import java.util.List;

import com.changjiang.common.Assist;
import com.changjiang.entity.SysCodeRule;

public interface SysCodeRuleService{
    long getSysCodeRuleRowCount(Assist assist);
    List<SysCodeRule> selectSysCodeRule(Assist assist);
    SysCodeRule selectSysCodeRuleById(Integer id);
    int insertSysCodeRule(SysCodeRule value);
    int insertNonEmptySysCodeRule(SysCodeRule value);
    int deleteSysCodeRuleById(Integer id);
    int deleteSysCodeRule(Assist assist);
    int updateSysCodeRuleById(SysCodeRule enti);
    int updateSysCodeRule(SysCodeRule value, Assist assist);
    int updateNonEmptySysCodeRuleById(SysCodeRule enti);
    int updateNonEmptySysCodeRule(SysCodeRule value, Assist assist);
}