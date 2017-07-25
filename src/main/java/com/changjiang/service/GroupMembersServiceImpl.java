package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.GroupMembersDao;
import com.changjiang.entity.GroupMembers;
import com.changjiang.common.Assist;
@Service
public class GroupMembersServiceImpl implements GroupMembersService{
    @Autowired
	private GroupMembersDao groupMembersDao;
    @Override
    public long getGroupMembersRowCount(Assist assist){
        return groupMembersDao.getGroupMembersRowCount(assist);
    }
    @Override
    public List<GroupMembers> selectGroupMembers(Assist assist){
        return groupMembersDao.selectGroupMembers(assist);
    }
    @Override
    public GroupMembers selectGroupMembersById(Integer id){
        return groupMembersDao.selectGroupMembersById(id);
    }
    @Override
    public int insertGroupMembers(GroupMembers value){
        return groupMembersDao.insertGroupMembers(value);
    }
    @Override
    public int insertNonEmptyGroupMembers(GroupMembers value){
        return groupMembersDao.insertNonEmptyGroupMembers(value);
    }
    @Override
    public int deleteGroupMembersById(Integer id){
        return groupMembersDao.deleteGroupMembersById(id);
    }
    @Override
    public int deleteGroupMembers(Assist assist){
        return groupMembersDao.deleteGroupMembers(assist);
    }
    @Override
    public int updateGroupMembersById(GroupMembers enti){
        return groupMembersDao.updateGroupMembersById(enti);
    }
    @Override
    public int updateGroupMembers(GroupMembers value, Assist assist){
        return groupMembersDao.updateGroupMembers(value,assist);
    }
    @Override
    public int updateNonEmptyGroupMembersById(GroupMembers enti){
        return groupMembersDao.updateNonEmptyGroupMembersById(enti);
    }
    @Override
    public int updateNonEmptyGroupMembers(GroupMembers value, Assist assist){
        return groupMembersDao.updateNonEmptyGroupMembers(value,assist);
    }

    public GroupMembersDao getGroupMembersDao() {
        return this.groupMembersDao;
    }

    public void setGroupMembersDao(GroupMembersDao groupMembersDao) {
        this.groupMembersDao = groupMembersDao;
    }

}