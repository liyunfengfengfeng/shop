package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.TimeManageDao;
import com.changjiang.entity.TimeManage;
import com.changjiang.common.Assist;
@Service
public class TimeManageServiceImpl implements TimeManageService{
    @Autowired
	private TimeManageDao timeManageDao;
    @Override
    public long getTimeManageRowCount(Assist assist){
        return timeManageDao.getTimeManageRowCount(assist);
    }
    @Override
    public List<TimeManage> selectTimeManage(Assist assist){
        return timeManageDao.selectTimeManage(assist);
    }
    @Override
    public TimeManage selectTimeManageById(Integer id){
        return timeManageDao.selectTimeManageById(id);
    }
    @Override
    public int insertTimeManage(TimeManage value){
        return timeManageDao.insertTimeManage(value);
    }
    @Override
    public int insertNonEmptyTimeManage(TimeManage value){
        return timeManageDao.insertNonEmptyTimeManage(value);
    }
    @Override
    public int deleteTimeManageById(Integer id){
        return timeManageDao.deleteTimeManageById(id);
    }
    @Override
    public int deleteTimeManage(Assist assist){
        return timeManageDao.deleteTimeManage(assist);
    }
    @Override
    public int updateTimeManageById(TimeManage enti){
        return timeManageDao.updateTimeManageById(enti);
    }
    @Override
    public int updateTimeManage(TimeManage value, Assist assist){
        return timeManageDao.updateTimeManage(value,assist);
    }
    @Override
    public int updateNonEmptyTimeManageById(TimeManage enti){
        return timeManageDao.updateNonEmptyTimeManageById(enti);
    }
    @Override
    public int updateNonEmptyTimeManage(TimeManage value, Assist assist){
        return timeManageDao.updateNonEmptyTimeManage(value,assist);
    }

    public TimeManageDao getTimeManageDao() {
        return this.timeManageDao;
    }

    public void setTimeManageDao(TimeManageDao timeManageDao) {
        this.timeManageDao = timeManageDao;
    }

}