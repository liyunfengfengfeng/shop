package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.OfficialUserInformation;
import com.changjiang.common.Assist;
public interface OfficialUserInformationService{
    long getOfficialUserInformationRowCount(Assist assist);
    List<OfficialUserInformation> selectOfficialUserInformation(Assist assist);
    OfficialUserInformation selectOfficialUserInformationById(Integer id);
    int insertOfficialUserInformation(OfficialUserInformation value);
    int insertNonEmptyOfficialUserInformation(OfficialUserInformation value);
    int deleteOfficialUserInformationById(Integer id);
    int deleteOfficialUserInformation(Assist assist);
    int updateOfficialUserInformationById(OfficialUserInformation enti);
    int updateOfficialUserInformation(OfficialUserInformation value, Assist assist);
    int updateNonEmptyOfficialUserInformationById(OfficialUserInformation enti);
    int updateNonEmptyOfficialUserInformation(OfficialUserInformation value, Assist assist);
}