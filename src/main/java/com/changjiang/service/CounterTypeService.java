package com.changjiang.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.changjiang.entity.CounterType;
import com.changjiang.common.Assist;
@Service
public interface CounterTypeService{
    long getCounterTypeRowCount(Assist assist);
    List<CounterType> selectCounterType(Assist assist);
    CounterType selectCounterTypeById(Integer id);
    int insertCounterType(CounterType value);
    int insertNonEmptyCounterType(CounterType value);
    int deleteCounterTypeById(Integer id);
    int deleteCounterType(Assist assist);
    int updateCounterTypeById(CounterType enti);
    int updateCounterType(CounterType value, Assist assist);
    int updateNonEmptyCounterTypeById(CounterType enti);
    int updateNonEmptyCounterType(CounterType value, Assist assist);
	/**
	 * 通过id查询柜台类别与其对应的柜台
	 * @param id
	 * @return
	 */
    List<CounterType> findCounterTypeAndCounter(Integer id);
}