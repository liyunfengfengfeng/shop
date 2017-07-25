package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.changjiang.common.Assist;
import com.changjiang.dao.CounterTypeDao;
import com.changjiang.entity.CounterType;

public class CounterTypeServiceImpl implements CounterTypeService{
    @Autowired
	private CounterTypeDao counterTypeDao;
    @Override
    public long getCounterTypeRowCount(Assist assist){
        return counterTypeDao.getCounterTypeRowCount(assist);
    }
    @Override
    public List<CounterType> selectCounterType(Assist assist){
        return counterTypeDao.selectCounterType(assist);
    }
    @Override
    public CounterType selectCounterTypeById(Integer id){
        return counterTypeDao.selectCounterTypeById(id);
    }
    @Override
    public int insertCounterType(CounterType value){
        return counterTypeDao.insertCounterType(value);
    }
    @Override
    public int insertNonEmptyCounterType(CounterType value){
        return counterTypeDao.insertNonEmptyCounterType(value);
    }
    @Override
    public int deleteCounterTypeById(Integer id){
        return counterTypeDao.deleteCounterTypeById(id);
    }
    @Override
    public int deleteCounterType(Assist assist){
        return counterTypeDao.deleteCounterType(assist);
    }
    @Override
    public int updateCounterTypeById(CounterType enti){
        return counterTypeDao.updateCounterTypeById(enti);
    }
    @Override
    public int updateCounterType(CounterType value, Assist assist){
        return counterTypeDao.updateCounterType(value,assist);
    }
    @Override
    public int updateNonEmptyCounterTypeById(CounterType enti){
        return counterTypeDao.updateNonEmptyCounterTypeById(enti);
    }
    @Override
    public int updateNonEmptyCounterType(CounterType value, Assist assist){
        return counterTypeDao.updateNonEmptyCounterType(value,assist);
    }

    public CounterTypeDao getCounterTypeDao() {
        return this.counterTypeDao;
    }

    public void setCounterTypeDao(CounterTypeDao counterTypeDao) {
        this.counterTypeDao = counterTypeDao;
    }
    /**
     * 通过id查询柜台类别与其对应的柜台
     */
	@Override
	public List<CounterType> findCounterTypeAndCounter(Integer id) {
		// TODO Auto-generated method stub
		return counterTypeDao.findCounterTypeAndCounter(id);
	}

}