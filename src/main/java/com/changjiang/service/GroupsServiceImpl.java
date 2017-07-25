package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.GroupsDao;
import com.changjiang.entity.Groups;
import com.changjiang.common.Assist;
@Service
public class GroupsServiceImpl implements GroupsService{
    @Autowired
	private GroupsDao groupsDao;
    @Override
    public long getGroupsRowCount(Assist assist){
        return groupsDao.getGroupsRowCount(assist);
    }
    @Override
    public List<Groups> selectGroups(Assist assist){
        return groupsDao.selectGroups(assist);
    }
    @Override
    public Groups selectGroupsById(Integer id){
        return groupsDao.selectGroupsById(id);
    }
    @Override
    public int insertGroups(Groups value){
        return groupsDao.insertGroups(value);
    }
    @Override
    public int insertNonEmptyGroups(Groups value){
        return groupsDao.insertNonEmptyGroups(value);
    }
    @Override
    public int deleteGroupsById(Integer id){
        return groupsDao.deleteGroupsById(id);
    }
    @Override
    public int deleteGroups(Assist assist){
        return groupsDao.deleteGroups(assist);
    }
    @Override
    public int updateGroupsById(Groups enti){
        return groupsDao.updateGroupsById(enti);
    }
    @Override
    public int updateGroups(Groups value, Assist assist){
        return groupsDao.updateGroups(value,assist);
    }
    @Override
    public int updateNonEmptyGroupsById(Groups enti){
        return groupsDao.updateNonEmptyGroupsById(enti);
    }
    @Override
    public int updateNonEmptyGroups(Groups value, Assist assist){
        return groupsDao.updateNonEmptyGroups(value,assist);
    }

    public GroupsDao getGroupsDao() {
        return this.groupsDao;
    }

    public void setGroupsDao(GroupsDao groupsDao) {
        this.groupsDao = groupsDao;
    }

}