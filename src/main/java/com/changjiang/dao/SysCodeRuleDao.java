package com.changjiang.dao;
import com.changjiang.common.Assist;
import com.changjiang.entity.SysCodeRule;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface SysCodeRuleDao{
    long getSysCodeRuleRowCount(Assist assist);
    List<SysCodeRule> selectSysCodeRule(Assist assist);
    SysCodeRule selectSysCodeRuleById(Integer id);
    int insertSysCodeRule(SysCodeRule value);
    int insertNonEmptySysCodeRule(SysCodeRule value);
    int deleteSysCodeRuleById(Integer id);
    int deleteSysCodeRule(Assist assist);
    int updateSysCodeRuleById(SysCodeRule enti);
    int updateSysCodeRule(@Param("enti") SysCodeRule value, @Param("assist") Assist assist);
    int updateNonEmptySysCodeRuleById(SysCodeRule enti);
    int updateNonEmptySysCodeRule(@Param("enti") SysCodeRule value, @Param("assist") Assist assist);
}