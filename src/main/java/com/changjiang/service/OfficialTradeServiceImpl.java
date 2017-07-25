package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.OfficialTradeDao;
import com.changjiang.entity.OfficialTrade;
import com.changjiang.common.Assist;
@Service
public class OfficialTradeServiceImpl implements OfficialTradeService{
	@Autowired
    private OfficialTradeDao officialTradeDao;
    @Override
    public long getOfficialTradeRowCount(Assist assist){
        return officialTradeDao.getOfficialTradeRowCount(assist);
    }
    @Override
    public List<OfficialTrade> selectOfficialTrade(Assist assist){
        return officialTradeDao.selectOfficialTrade(assist);
    }
    @Override
    public OfficialTrade selectOfficialTradeById(Integer id){
        return officialTradeDao.selectOfficialTradeById(id);
    }
    @Override
    public int insertOfficialTrade(OfficialTrade value){
        return officialTradeDao.insertOfficialTrade(value);
    }
    @Override
    public int insertNonEmptyOfficialTrade(OfficialTrade value){
        return officialTradeDao.insertNonEmptyOfficialTrade(value);
    }
    @Override
    public int deleteOfficialTradeById(Integer id){
        return officialTradeDao.deleteOfficialTradeById(id);
    }
    @Override
    public int deleteOfficialTrade(Assist assist){
        return officialTradeDao.deleteOfficialTrade(assist);
    }
    @Override
    public int updateOfficialTradeById(OfficialTrade enti){
        return officialTradeDao.updateOfficialTradeById(enti);
    }
    @Override
    public int updateOfficialTrade(OfficialTrade value, Assist assist){
        return officialTradeDao.updateOfficialTrade(value,assist);
    }
    @Override
    public int updateNonEmptyOfficialTradeById(OfficialTrade enti){
        return officialTradeDao.updateNonEmptyOfficialTradeById(enti);
    }
    @Override
    public int updateNonEmptyOfficialTrade(OfficialTrade value, Assist assist){
        return officialTradeDao.updateNonEmptyOfficialTrade(value,assist);
    }

    public OfficialTradeDao getOfficialTradeDao() {
        return this.officialTradeDao;
    }

    public void setOfficialTradeDao(OfficialTradeDao officialTradeDao) {
        this.officialTradeDao = officialTradeDao;
    }

}