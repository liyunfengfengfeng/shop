package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.Groups;
import com.changjiang.common.Assist;
public interface GroupsService{
    long getGroupsRowCount(Assist assist);
    List<Groups> selectGroups(Assist assist);
    Groups selectGroupsById(Integer id);
    int insertGroups(Groups value);
    int insertNonEmptyGroups(Groups value);
    int deleteGroupsById(Integer id);
    int deleteGroups(Assist assist);
    int updateGroupsById(Groups enti);
    int updateGroups(Groups value, Assist assist);
    int updateNonEmptyGroupsById(Groups enti);
    int updateNonEmptyGroups(Groups value, Assist assist);
}