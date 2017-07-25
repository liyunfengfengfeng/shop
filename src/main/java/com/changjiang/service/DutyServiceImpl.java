package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.DutyDao;
import com.changjiang.dao.StoreDao;
import com.changjiang.entity.Duty;
import com.changjiang.common.Assist;
@Service
public class DutyServiceImpl implements DutyService{
    @Autowired
	private DutyDao dutyDao;
    @Autowired
    private StoreDao storeDao;
    @Override
    public long getDutyRowCount(Assist assist){
        return dutyDao.getDutyRowCount(assist);
    }
    @Override
    public List<Duty> selectDuty(Assist assist){
        return dutyDao.selectDuty(assist);
    }
    @Override
    public Duty selectDutyById(Integer id){
        return dutyDao.selectDutyById(id);
    }
    @Override
    public int insertDuty(Duty value){
        return dutyDao.insertDuty(value);
    }
    @Override
    public int insertNonEmptyDuty(Duty value){
        return dutyDao.insertNonEmptyDuty(value);
    }
    @Override
    public int deleteDutyById(Integer id){
        return dutyDao.deleteDutyById(id);
    }
    @Override
    public int deleteDuty(Assist assist){
        return dutyDao.deleteDuty(assist);
    }
    @Override
    public int updateDutyById(Duty enti){
        return dutyDao.updateDutyById(enti);
    }
    @Override
    public int updateDuty(Duty value, Assist assist){
        return dutyDao.updateDuty(value,assist);
    }
    @Override
    public int updateNonEmptyDutyById(Duty enti){
        return dutyDao.updateNonEmptyDutyById(enti);
    }
    @Override
    public int updateNonEmptyDuty(Duty value, Assist assist){
        return dutyDao.updateNonEmptyDuty(value,assist);
    }

    public DutyDao getDutyDao() {
        return this.dutyDao;
    }

    public void setDutyDao(DutyDao dutyDao) {
        this.dutyDao = dutyDao;
    }
    /**
	 * 通过id查询duty以及其下的userinfomation
	 */
	@Override
	public List<Duty> findDutyAndUserInfo(Integer id) {
		// TODO Auto-generated method stub
		return dutyDao.findDutyAndUserInfo(id);
	}
	@Override
	public List<Duty> selectDutyByStoreNumber(String storeNumber) {
		Integer store_id=storeDao.selectIdByStoreNumber(storeNumber);
		Assist.and_eq("store_id",store_id.toString());
		List<Duty> duties=dutyDao.selectDuty(new Assist());
		// TODO Auto-generated method stub
		return duties;
	}
}