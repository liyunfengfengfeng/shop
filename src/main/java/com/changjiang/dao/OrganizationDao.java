package com.changjiang.dao;
import com.changjiang.entity.Organization;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface OrganizationDao{
    long getOrganizationRowCount(Assist assist);
    List<Organization> selectOrganization(Assist assist);
    Organization selectOrganizationById(Integer id);
    int insertOrganization(Organization value);
    int insertNonEmptyOrganization(Organization value);
    int deleteOrganizationById(Integer id);
    int deleteOrganization(Assist assist);
    int updateOrganizationById(Organization enti);
    int updateOrganization(@Param("enti") Organization value, @Param("assist") Assist assist);
    int updateNonEmptyOrganizationById(Organization enti);
    int updateNonEmptyOrganization(@Param("enti") Organization value, @Param("assist") Assist assist);
    /**
     * 查询某组织下的所有组织
     */
    List<Organization> selectOrganizationByCurrentLevelId(Integer upperlevelid);
}