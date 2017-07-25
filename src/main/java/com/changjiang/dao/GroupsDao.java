package com.changjiang.dao;
import com.changjiang.entity.Groups;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface GroupsDao{
    long getGroupsRowCount(Assist assist);
    List<Groups> selectGroups(Assist assist);
    Groups selectGroupsById(Integer id);
    int insertGroups(Groups value);
    int insertNonEmptyGroups(Groups value);
    int deleteGroupsById(Integer id);
    int deleteGroups(Assist assist);
    int updateGroupsById(Groups enti);
    int updateGroups(@Param("enti") Groups value, @Param("assist") Assist assist);
    int updateNonEmptyGroupsById(Groups enti);
    int updateNonEmptyGroups(@Param("enti") Groups value, @Param("assist") Assist assist);
}