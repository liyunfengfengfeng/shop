package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.DutyRecord;
import com.changjiang.common.Assist;
public interface DutyRecordService{
    long getDutyRecordRowCount(Assist assist);
    List<DutyRecord> selectDutyRecord(Assist assist);
    DutyRecord selectDutyRecordById(Integer id);
    int insertDutyRecord(DutyRecord value);
    int insertNonEmptyDutyRecord(DutyRecord value);
    int deleteDutyRecordById(Integer id);
    int deleteDutyRecord(Assist assist);
    int updateDutyRecordById(DutyRecord enti);
    int updateDutyRecord(DutyRecord value, Assist assist);
    int updateNonEmptyDutyRecordById(DutyRecord enti);
    int updateNonEmptyDutyRecord(DutyRecord value, Assist assist);
}