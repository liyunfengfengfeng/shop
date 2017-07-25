package com.changjiang.dao;
import com.changjiang.entity.OfficialProducteSpeciality;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface OfficialProducteSpecialityDao{
    long getOfficialProducteSpecialityRowCount(Assist assist);
    List<OfficialProducteSpeciality> selectOfficialProducteSpeciality(Assist assist);
    OfficialProducteSpeciality selectOfficialProducteSpecialityById(Integer id);
    int insertOfficialProducteSpeciality(OfficialProducteSpeciality value);
    int insertNonEmptyOfficialProducteSpeciality(OfficialProducteSpeciality value);
    int deleteOfficialProducteSpecialityById(Integer id);
    int deleteOfficialProducteSpeciality(Assist assist);
    int updateOfficialProducteSpecialityById(OfficialProducteSpeciality enti);
    int updateOfficialProducteSpeciality(@Param("enti") OfficialProducteSpeciality value, @Param("assist") Assist assist);
    int updateNonEmptyOfficialProducteSpecialityById(OfficialProducteSpeciality enti);
    int updateNonEmptyOfficialProducteSpeciality(@Param("enti") OfficialProducteSpeciality value, @Param("assist") Assist assist);
}