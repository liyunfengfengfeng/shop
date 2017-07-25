package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.changjiang.common.Assist;
import com.changjiang.dao.AreaDao;
import com.changjiang.entity.Area;

public class AreaServiceImpl implements AreaService{
    @Autowired
	private AreaDao areaDao;
    @Override
    public long getAreaRowCount(Assist assist){
        return areaDao.getAreaRowCount(assist);
    }
    @Override
    public List<Area> selectArea(Assist assist){
        return areaDao.selectArea(assist);
    }
    @Override
    public Area selectAreaById(Integer id){
        return areaDao.selectAreaById(id);
    }
    @Override
    public int insertArea(Area value){
        return areaDao.insertArea(value);
    }
    @Override
    public int insertNonEmptyArea(Area value){
        return areaDao.insertNonEmptyArea(value);
    }
    @Override
    public int deleteAreaById(Integer id){
        return areaDao.deleteAreaById(id);
    }
    @Override
    public int deleteArea(Assist assist){
        return areaDao.deleteArea(assist);
    }
    @Override
    public int updateAreaById(Area enti){
        return areaDao.updateAreaById(enti);
    }
    @Override
    public int updateArea(Area value, Assist assist){
        return areaDao.updateArea(value,assist);
    }
    @Override
    public int updateNonEmptyAreaById(Area enti){
        return areaDao.updateNonEmptyAreaById(enti);
    }
    @Override
    public int updateNonEmptyArea(Area value, Assist assist){
        return areaDao.updateNonEmptyArea(value,assist);
    }

    public AreaDao getAreaDao() {
        return this.areaDao;
    }

    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }
    /**
	 * 查询区域以及区域下的柜台
	 */
	@Override
	public List<Area> findAreaAndCounter(Integer id) {
		// TODO Auto-generated method stub
		return areaDao.findAreaAndCounter(id);
	}

}