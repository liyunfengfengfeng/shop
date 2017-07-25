package com.changjiang.dao;
import com.changjiang.entity.DutyRecord;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface DutyRecordDao{
    long getDutyRecordRowCount(Assist assist);
    List<DutyRecord> selectDutyRecord(Assist assist);
    DutyRecord selectDutyRecordById(Integer id);
    int insertDutyRecord(DutyRecord value);
    int insertNonEmptyDutyRecord(DutyRecord value);
    int deleteDutyRecordById(Integer id);
    int deleteDutyRecord(Assist assist);
    int updateDutyRecordById(DutyRecord enti);
    int updateDutyRecord(@Param("enti") DutyRecord value, @Param("assist") Assist assist);
    int updateNonEmptyDutyRecordById(DutyRecord enti);
    int updateNonEmptyDutyRecord(@Param("enti") DutyRecord value, @Param("assist") Assist assist);
}