package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.OfficialProducteSpeciality;
import com.changjiang.common.Assist;
public interface OfficialProducteSpecialityService{
    long getOfficialProducteSpecialityRowCount(Assist assist);
    List<OfficialProducteSpeciality> selectOfficialProducteSpeciality(Assist assist);
    OfficialProducteSpeciality selectOfficialProducteSpecialityById(Integer id);
    int insertOfficialProducteSpeciality(OfficialProducteSpeciality value);
    int insertNonEmptyOfficialProducteSpeciality(OfficialProducteSpeciality value);
    int deleteOfficialProducteSpecialityById(Integer id);
    int deleteOfficialProducteSpeciality(Assist assist);
    int updateOfficialProducteSpecialityById(OfficialProducteSpeciality enti);
    int updateOfficialProducteSpeciality(OfficialProducteSpeciality value, Assist assist);
    int updateNonEmptyOfficialProducteSpecialityById(OfficialProducteSpeciality enti);
    int updateNonEmptyOfficialProducteSpeciality(OfficialProducteSpeciality value, Assist assist);
}