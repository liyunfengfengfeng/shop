package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.CounterWorkStationRecordDao;
import com.changjiang.entity.CounterWorkStationRecord;
import com.changjiang.common.Assist;
@Service
public class CounterWorkStationRecordServiceImpl implements CounterWorkStationRecordService{
    @Autowired
	private CounterWorkStationRecordDao counterWorkStationRecordDao;
    @Override
    public long getCounterWorkStationRecordRowCount(Assist assist){
        return counterWorkStationRecordDao.getCounterWorkStationRecordRowCount(assist);
    }
    @Override
    public List<CounterWorkStationRecord> selectCounterWorkStationRecord(Assist assist){
        return counterWorkStationRecordDao.selectCounterWorkStationRecord(assist);
    }
    @Override
    public CounterWorkStationRecord selectCounterWorkStationRecordById(Integer id){
        return counterWorkStationRecordDao.selectCounterWorkStationRecordById(id);
    }
    @Override
    public int insertCounterWorkStationRecord(CounterWorkStationRecord value){
        return counterWorkStationRecordDao.insertCounterWorkStationRecord(value);
    }
    @Override
    public int insertNonEmptyCounterWorkStationRecord(CounterWorkStationRecord value){
        return counterWorkStationRecordDao.insertNonEmptyCounterWorkStationRecord(value);
    }
    @Override
    public int deleteCounterWorkStationRecordById(Integer id){
        return counterWorkStationRecordDao.deleteCounterWorkStationRecordById(id);
    }
    @Override
    public int deleteCounterWorkStationRecord(Assist assist){
        return counterWorkStationRecordDao.deleteCounterWorkStationRecord(assist);
    }
    @Override
    public int updateCounterWorkStationRecordById(CounterWorkStationRecord enti){
        return counterWorkStationRecordDao.updateCounterWorkStationRecordById(enti);
    }
    @Override
    public int updateCounterWorkStationRecord(CounterWorkStationRecord value, Assist assist){
        return counterWorkStationRecordDao.updateCounterWorkStationRecord(value,assist);
    }
    @Override
    public int updateNonEmptyCounterWorkStationRecordById(CounterWorkStationRecord enti){
        return counterWorkStationRecordDao.updateNonEmptyCounterWorkStationRecordById(enti);
    }
    @Override
    public int updateNonEmptyCounterWorkStationRecord(CounterWorkStationRecord value, Assist assist){
        return counterWorkStationRecordDao.updateNonEmptyCounterWorkStationRecord(value,assist);
    }

    public CounterWorkStationRecordDao getCounterWorkStationRecordDao() {
        return this.counterWorkStationRecordDao;
    }

    public void setCounterWorkStationRecordDao(CounterWorkStationRecordDao counterWorkStationRecordDao) {
        this.counterWorkStationRecordDao = counterWorkStationRecordDao;
    }

}