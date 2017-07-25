package com.changjiang.service;
import java.util.List;
import com.changjiang.dao.OfficialProducteSpecialityDao;
import com.changjiang.entity.OfficialProducteSpeciality;
import com.changjiang.common.Assist;
public class OfficialProducteSpecialityServiceImpl implements OfficialProducteSpecialityService{
    private OfficialProducteSpecialityDao officialProducteSpecialityDao;
    @Override
    public long getOfficialProducteSpecialityRowCount(Assist assist){
        return officialProducteSpecialityDao.getOfficialProducteSpecialityRowCount(assist);
    }
    @Override
    public List<OfficialProducteSpeciality> selectOfficialProducteSpeciality(Assist assist){
        return officialProducteSpecialityDao.selectOfficialProducteSpeciality(assist);
    }
    @Override
    public OfficialProducteSpeciality selectOfficialProducteSpecialityById(Integer id){
        return officialProducteSpecialityDao.selectOfficialProducteSpecialityById(id);
    }
    @Override
    public int insertOfficialProducteSpeciality(OfficialProducteSpeciality value){
        return officialProducteSpecialityDao.insertOfficialProducteSpeciality(value);
    }
    @Override
    public int insertNonEmptyOfficialProducteSpeciality(OfficialProducteSpeciality value){
        return officialProducteSpecialityDao.insertNonEmptyOfficialProducteSpeciality(value);
    }
    @Override
    public int deleteOfficialProducteSpecialityById(Integer id){
        return officialProducteSpecialityDao.deleteOfficialProducteSpecialityById(id);
    }
    @Override
    public int deleteOfficialProducteSpeciality(Assist assist){
        return officialProducteSpecialityDao.deleteOfficialProducteSpeciality(assist);
    }
    @Override
    public int updateOfficialProducteSpecialityById(OfficialProducteSpeciality enti){
        return officialProducteSpecialityDao.updateOfficialProducteSpecialityById(enti);
    }
    @Override
    public int updateOfficialProducteSpeciality(OfficialProducteSpeciality value, Assist assist){
        return officialProducteSpecialityDao.updateOfficialProducteSpeciality(value,assist);
    }
    @Override
    public int updateNonEmptyOfficialProducteSpecialityById(OfficialProducteSpeciality enti){
        return officialProducteSpecialityDao.updateNonEmptyOfficialProducteSpecialityById(enti);
    }
    @Override
    public int updateNonEmptyOfficialProducteSpeciality(OfficialProducteSpeciality value, Assist assist){
        return officialProducteSpecialityDao.updateNonEmptyOfficialProducteSpeciality(value,assist);
    }

    public OfficialProducteSpecialityDao getOfficialProducteSpecialityDao() {
        return this.officialProducteSpecialityDao;
    }

    public void setOfficialProducteSpecialityDao(OfficialProducteSpecialityDao officialProducteSpecialityDao) {
        this.officialProducteSpecialityDao = officialProducteSpecialityDao;
    }

}