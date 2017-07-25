package com.changjiang.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.changjiang.entity.WorkStation;
import com.changjiang.common.Assist;
@Service
public interface WorkStationService{
    long getWorkStationRowCount(Assist assist);
    List<WorkStation> selectWorkStation(Assist assist);
    WorkStation selectWorkStationById(Integer id);
    int insertWorkStation(WorkStation value);
    int insertNonEmptyWorkStation(WorkStation value);
    int deleteWorkStationById(Integer id);
    int deleteWorkStation(Assist assist);
    int updateWorkStationById(WorkStation enti);
    int updateWorkStation(WorkStation value, Assist assist);
    int updateNonEmptyWorkStationById(WorkStation enti);
    int updateNonEmptyWorkStation(WorkStation value, Assist assist);
    List<WorkStation> selectWorkStationByStoreId(Integer id);
    /**
	 * 通过id查询岗位和岗位所对应的记录
	 */
    List<WorkStation> findWorkStationAndRecord(Integer id);
	
    /**
	 * 通过id查询岗位和counter_work_station_record
	 */
    List<WorkStation> findWorkStationAndCounterStationRecord(Integer id);
}