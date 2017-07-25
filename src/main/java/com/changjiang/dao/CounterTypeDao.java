package com.changjiang.dao;
import com.changjiang.entity.CounterType;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface CounterTypeDao{
    long getCounterTypeRowCount(Assist assist);
    List<CounterType> selectCounterType(Assist assist);
    CounterType selectCounterTypeById(Integer id);
    int insertCounterType(CounterType value);
    int insertNonEmptyCounterType(CounterType value);
    int deleteCounterTypeById(Integer id);
    int deleteCounterType(Assist assist);
    int updateCounterTypeById(CounterType enti);
    int updateCounterType(@Param("enti") CounterType value, @Param("assist") Assist assist);
    int updateNonEmptyCounterTypeById(CounterType enti);
    int updateNonEmptyCounterType(@Param("enti") CounterType value, @Param("assist") Assist assist);
    /**
     * 通过id查询柜台类别与其对应的柜台
     */
    List<CounterType> findCounterTypeAndCounter(Integer id);
}