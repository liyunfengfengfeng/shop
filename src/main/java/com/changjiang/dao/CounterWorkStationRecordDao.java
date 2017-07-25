package com.changjiang.dao;
import com.changjiang.entity.CounterWorkStationRecord;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface CounterWorkStationRecordDao{
    long getCounterWorkStationRecordRowCount(Assist assist);
    List<CounterWorkStationRecord> selectCounterWorkStationRecord(Assist assist);
    CounterWorkStationRecord selectCounterWorkStationRecordById(Integer id);
    int insertCounterWorkStationRecord(CounterWorkStationRecord value);
    int insertNonEmptyCounterWorkStationRecord(CounterWorkStationRecord value);
    int deleteCounterWorkStationRecordById(Integer id);
    int deleteCounterWorkStationRecord(Assist assist);
    int updateCounterWorkStationRecordById(CounterWorkStationRecord enti);
    int updateCounterWorkStationRecord(@Param("enti") CounterWorkStationRecord value, @Param("assist") Assist assist);
    int updateNonEmptyCounterWorkStationRecordById(CounterWorkStationRecord enti);
    int updateNonEmptyCounterWorkStationRecord(@Param("enti") CounterWorkStationRecord value, @Param("assist") Assist assist);
}