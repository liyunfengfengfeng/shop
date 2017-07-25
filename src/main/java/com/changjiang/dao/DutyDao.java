package com.changjiang.dao;
import com.changjiang.entity.Duty;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface DutyDao{
    long getDutyRowCount(Assist assist);
    List<Duty> selectDuty(Assist assist);
    Duty selectDutyById(Integer id);
    int insertDuty(Duty value);
    int insertNonEmptyDuty(Duty value);
    int deleteDutyById(Integer id);
    int deleteDuty(Assist assist);
    int updateDutyById(Duty enti);
    int updateDuty(@Param("enti") Duty value, @Param("assist") Assist assist);
    int updateNonEmptyDutyById(Duty enti);
    int updateNonEmptyDuty(@Param("enti") Duty value, @Param("assist") Assist assist);
    /**
	 * 通过id查询duty以及其下的userinfomation
	 */
    List<Duty> findDutyAndUserInfo(Integer id);
}