package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.WorkstationRecordDao;
import com.changjiang.entity.WorkstationRecord;
import com.changjiang.common.Assist;
@Service
public class WorkstationRecordServiceImpl implements WorkstationRecordService{
    @Autowired
	private WorkstationRecordDao workstationRecordDao;
    @Override
    public long getWorkstationRecordRowCount(Assist assist){
        return workstationRecordDao.getWorkstationRecordRowCount(assist);
    }
    @Override
    public List<WorkstationRecord> selectWorkstationRecord(Assist assist){
        return workstationRecordDao.selectWorkstationRecord(assist);
    }
    @Override
    public WorkstationRecord selectWorkstationRecordById(Integer id){
        return workstationRecordDao.selectWorkstationRecordById(id);
    }
    @Override
    public int insertWorkstationRecord(WorkstationRecord value){
        return workstationRecordDao.insertWorkstationRecord(value);
    }
    @Override
    public int insertNonEmptyWorkstationRecord(WorkstationRecord value){
        return workstationRecordDao.insertNonEmptyWorkstationRecord(value);
    }
    @Override
    public int deleteWorkstationRecordById(Integer id){
        return workstationRecordDao.deleteWorkstationRecordById(id);
    }
    @Override
    public int deleteWorkstationRecord(Assist assist){
        return workstationRecordDao.deleteWorkstationRecord(assist);
    }
    @Override
    public int updateWorkstationRecordById(WorkstationRecord enti){
        return workstationRecordDao.updateWorkstationRecordById(enti);
    }
    @Override
    public int updateWorkstationRecord(WorkstationRecord value, Assist assist){
        return workstationRecordDao.updateWorkstationRecord(value,assist);
    }
    @Override
    public int updateNonEmptyWorkstationRecordById(WorkstationRecord enti){
        return workstationRecordDao.updateNonEmptyWorkstationRecordById(enti);
    }
    @Override
    public int updateNonEmptyWorkstationRecord(WorkstationRecord value, Assist assist){
        return workstationRecordDao.updateNonEmptyWorkstationRecord(value,assist);
    }

    public WorkstationRecordDao getWorkstationRecordDao() {
        return this.workstationRecordDao;
    }

    public void setWorkstationRecordDao(WorkstationRecordDao workstationRecordDao) {
        this.workstationRecordDao = workstationRecordDao;
    }

}