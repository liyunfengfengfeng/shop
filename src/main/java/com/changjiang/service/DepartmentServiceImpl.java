package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.DepartmentDao;
import com.changjiang.entity.Department;
import com.changjiang.common.Assist;
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
	private DepartmentDao departmentDao;
    @Override
    public long getDepartmentRowCount(Assist assist){
        return departmentDao.getDepartmentRowCount(assist);
    }
    @Override
    public List<Department> selectDepartment(Assist assist){
        return departmentDao.selectDepartment(assist);
    }
    @Override
    public Department selectDepartmentById(Integer id){
        return departmentDao.selectDepartmentById(id);
    }
    @Override
    public int insertDepartment(Department value){
        return departmentDao.insertDepartment(value);
    }
    @Override
    public int insertNonEmptyDepartment(Department value){
        return departmentDao.insertNonEmptyDepartment(value);
    }
    @Override
    public int deleteDepartmentById(Integer id){
        return departmentDao.deleteDepartmentById(id);
    }
    @Override
    public int deleteDepartment(Assist assist){
        return departmentDao.deleteDepartment(assist);
    }
    @Override
    public int updateDepartmentById(Department enti){
        return departmentDao.updateDepartmentById(enti);
    }
    @Override
    public int updateDepartment(Department value, Assist assist){
        return departmentDao.updateDepartment(value,assist);
    }
    @Override
    public int updateNonEmptyDepartmentById(Department enti){
        return departmentDao.updateNonEmptyDepartmentById(enti);
    }
    @Override
    public int updateNonEmptyDepartment(Department value, Assist assist){
        return departmentDao.updateNonEmptyDepartment(value,assist);
    }

    public DepartmentDao getDepartmentDao() {
        return this.departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
    /**
	 * 通过id查询department与其对应的workstation岗位
	 * @param id
	 * @return
	 */
	@Override
	public List<Department> findDepartmentAndWorkStation(Integer id) {
		// TODO Auto-generated method stub
		return departmentDao.findDepartmentAndWorkStation(id);
	}

}