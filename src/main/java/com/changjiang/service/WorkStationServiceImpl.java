package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.WorkStationDao;
import com.changjiang.entity.WorkStation;
import com.changjiang.common.Assist;
@Service
public class WorkStationServiceImpl implements WorkStationService{
    @Autowired
	private WorkStationDao workStationDao;
    @Override
    public long getWorkStationRowCount(Assist assist){
        return workStationDao.getWorkStationRowCount(assist);
    }
    @Override
    public List<WorkStation> selectWorkStation(Assist assist){
        return workStationDao.selectWorkStation(assist);
    }
    @Override
    public WorkStation selectWorkStationById(Integer id){
        return workStationDao.selectWorkStationById(id);
    }
    @Override
    public int insertWorkStation(WorkStation value){
        return workStationDao.insertWorkStation(value);
    }
    @Override
    public int insertNonEmptyWorkStation(WorkStation value){
        return workStationDao.insertNonEmptyWorkStation(value);
    }
    @Override
    public int deleteWorkStationById(Integer id){
        return workStationDao.deleteWorkStationById(id);
    }
    @Override
    public int deleteWorkStation(Assist assist){
        return workStationDao.deleteWorkStation(assist);
    }
    @Override
    public int updateWorkStationById(WorkStation enti){
        return workStationDao.updateWorkStationById(enti);
    }
    @Override
    public int updateWorkStation(WorkStation value, Assist assist){
        return workStationDao.updateWorkStation(value,assist);
    }
    @Override
    public int updateNonEmptyWorkStationById(WorkStation enti){
        return workStationDao.updateNonEmptyWorkStationById(enti);
    }
    @Override
    public int updateNonEmptyWorkStation(WorkStation value, Assist assist){
        return workStationDao.updateNonEmptyWorkStation(value,assist);
    }

    public WorkStationDao getWorkStationDao() {
        return this.workStationDao;
    }

    public void setWorkStationDao(WorkStationDao workStationDao) {
        this.workStationDao = workStationDao;
    }
	@Override
	public List<WorkStation> selectWorkStationByStoreId(Integer id) {
		List<WorkStation> workStations=workStationDao.selectWorkStationByStoreId(id);
		// TODO Auto-generated method stub
		return workStations;
	}
    /**
	 * 通过id查询岗位和岗位所对应的记录
	 */
	@Override
	public List<WorkStation> findWorkStationAndRecord(Integer id) {
		// TODO Auto-generated method stub
		return workStationDao.findWorkStationAndRecord(id);
	}
	/**
	 * 通过id查询岗位和counter_work_station_record
	 */
	@Override
	public List<WorkStation> findWorkStationAndCounterStationRecord(Integer id) {
		// TODO Auto-generated method stub
		return workStationDao.findWorkStationAndCounterStationRecord(id);
	}

}