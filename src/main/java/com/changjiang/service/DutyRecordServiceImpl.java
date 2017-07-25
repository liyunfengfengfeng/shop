package com.changjiang.service;
import java.util.List;
import com.changjiang.dao.DutyRecordDao;
import com.changjiang.entity.DutyRecord;
import com.changjiang.common.Assist;
public class DutyRecordServiceImpl implements DutyRecordService{
    private DutyRecordDao dutyRecordDao;
    @Override
    public long getDutyRecordRowCount(Assist assist){
        return dutyRecordDao.getDutyRecordRowCount(assist);
    }
    @Override
    public List<DutyRecord> selectDutyRecord(Assist assist){
        return dutyRecordDao.selectDutyRecord(assist);
    }
    @Override
    public DutyRecord selectDutyRecordById(Integer id){
        return dutyRecordDao.selectDutyRecordById(id);
    }
    @Override
    public int insertDutyRecord(DutyRecord value){
        return dutyRecordDao.insertDutyRecord(value);
    }
    @Override
    public int insertNonEmptyDutyRecord(DutyRecord value){
        return dutyRecordDao.insertNonEmptyDutyRecord(value);
    }
    @Override
    public int deleteDutyRecordById(Integer id){
        return dutyRecordDao.deleteDutyRecordById(id);
    }
    @Override
    public int deleteDutyRecord(Assist assist){
        return dutyRecordDao.deleteDutyRecord(assist);
    }
    @Override
    public int updateDutyRecordById(DutyRecord enti){
        return dutyRecordDao.updateDutyRecordById(enti);
    }
    @Override
    public int updateDutyRecord(DutyRecord value, Assist assist){
        return dutyRecordDao.updateDutyRecord(value,assist);
    }
    @Override
    public int updateNonEmptyDutyRecordById(DutyRecord enti){
        return dutyRecordDao.updateNonEmptyDutyRecordById(enti);
    }
    @Override
    public int updateNonEmptyDutyRecord(DutyRecord value, Assist assist){
        return dutyRecordDao.updateNonEmptyDutyRecord(value,assist);
    }

    public DutyRecordDao getDutyRecordDao() {
        return this.dutyRecordDao;
    }

    public void setDutyRecordDao(DutyRecordDao dutyRecordDao) {
        this.dutyRecordDao = dutyRecordDao;
    }

}