package com.changjiang.service;
import java.util.List;
import com.changjiang.dao.OfficialUserInformationDao;
import com.changjiang.entity.OfficialUserInformation;
import com.changjiang.common.Assist;
public class OfficialUserInformationServiceImpl implements OfficialUserInformationService{
    private OfficialUserInformationDao officialUserInformationDao;
    @Override
    public long getOfficialUserInformationRowCount(Assist assist){
        return officialUserInformationDao.getOfficialUserInformationRowCount(assist);
    }
    @Override
    public List<OfficialUserInformation> selectOfficialUserInformation(Assist assist){
        return officialUserInformationDao.selectOfficialUserInformation(assist);
    }
    @Override
    public OfficialUserInformation selectOfficialUserInformationById(Integer id){
        return officialUserInformationDao.selectOfficialUserInformationById(id);
    }
    @Override
    public int insertOfficialUserInformation(OfficialUserInformation value){
        return officialUserInformationDao.insertOfficialUserInformation(value);
    }
    @Override
    public int insertNonEmptyOfficialUserInformation(OfficialUserInformation value){
        return officialUserInformationDao.insertNonEmptyOfficialUserInformation(value);
    }
    @Override
    public int deleteOfficialUserInformationById(Integer id){
        return officialUserInformationDao.deleteOfficialUserInformationById(id);
    }
    @Override
    public int deleteOfficialUserInformation(Assist assist){
        return officialUserInformationDao.deleteOfficialUserInformation(assist);
    }
    @Override
    public int updateOfficialUserInformationById(OfficialUserInformation enti){
        return officialUserInformationDao.updateOfficialUserInformationById(enti);
    }
    @Override
    public int updateOfficialUserInformation(OfficialUserInformation value, Assist assist){
        return officialUserInformationDao.updateOfficialUserInformation(value,assist);
    }
    @Override
    public int updateNonEmptyOfficialUserInformationById(OfficialUserInformation enti){
        return officialUserInformationDao.updateNonEmptyOfficialUserInformationById(enti);
    }
    @Override
    public int updateNonEmptyOfficialUserInformation(OfficialUserInformation value, Assist assist){
        return officialUserInformationDao.updateNonEmptyOfficialUserInformation(value,assist);
    }

    public OfficialUserInformationDao getOfficialUserInformationDao() {
        return this.officialUserInformationDao;
    }

    public void setOfficialUserInformationDao(OfficialUserInformationDao officialUserInformationDao) {
        this.officialUserInformationDao = officialUserInformationDao;
    }

}