package com.changjiang.dao;
import com.changjiang.entity.WorkstationRecord;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface WorkstationRecordDao{
    long getWorkstationRecordRowCount(Assist assist);
    List<WorkstationRecord> selectWorkstationRecord(Assist assist);
    WorkstationRecord selectWorkstationRecordById(Integer id);
    int insertWorkstationRecord(WorkstationRecord value);
    int insertNonEmptyWorkstationRecord(WorkstationRecord value);
    int deleteWorkstationRecordById(Integer id);
    int deleteWorkstationRecord(Assist assist);
    int updateWorkstationRecordById(WorkstationRecord enti);
    int updateWorkstationRecord(@Param("enti") WorkstationRecord value, @Param("assist") Assist assist);
    int updateNonEmptyWorkstationRecordById(WorkstationRecord enti);
    int updateNonEmptyWorkstationRecord(@Param("enti") WorkstationRecord value, @Param("assist") Assist assist);
}