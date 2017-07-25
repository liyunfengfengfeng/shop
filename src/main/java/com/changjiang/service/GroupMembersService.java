package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.GroupMembers;
import com.changjiang.common.Assist;
public interface GroupMembersService{
    long getGroupMembersRowCount(Assist assist);
    List<GroupMembers> selectGroupMembers(Assist assist);
    GroupMembers selectGroupMembersById(Integer id);
    int insertGroupMembers(GroupMembers value);
    int insertNonEmptyGroupMembers(GroupMembers value);
    int deleteGroupMembersById(Integer id);
    int deleteGroupMembers(Assist assist);
    int updateGroupMembersById(GroupMembers enti);
    int updateGroupMembers(GroupMembers value, Assist assist);
    int updateNonEmptyGroupMembersById(GroupMembers enti);
    int updateNonEmptyGroupMembers(GroupMembers value, Assist assist);
}