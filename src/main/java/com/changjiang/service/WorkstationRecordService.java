package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.WorkstationRecord;
import com.changjiang.common.Assist;
public interface WorkstationRecordService{
    long getWorkstationRecordRowCount(Assist assist);
    List<WorkstationRecord> selectWorkstationRecord(Assist assist);
    WorkstationRecord selectWorkstationRecordById(Integer id);
    int insertWorkstationRecord(WorkstationRecord value);
    int insertNonEmptyWorkstationRecord(WorkstationRecord value);
    int deleteWorkstationRecordById(Integer id);
    int deleteWorkstationRecord(Assist assist);
    int updateWorkstationRecordById(WorkstationRecord enti);
    int updateWorkstationRecord(WorkstationRecord value, Assist assist);
    int updateNonEmptyWorkstationRecordById(WorkstationRecord enti);
    int updateNonEmptyWorkstationRecord(WorkstationRecord value, Assist assist);
}