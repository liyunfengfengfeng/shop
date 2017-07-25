package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.changjiang.dao.ServiceDao;
import com.changjiang.entity.Service;
import com.changjiang.common.Assist;
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService{
    @Autowired
	private ServiceDao serviceDao;
    @Override
    public long getServiceRowCount(Assist assist){
        return serviceDao.getServiceRowCount(assist);
    }
    @Override
    public List<Service> selectService(Assist assist){
        return serviceDao.selectService(assist);
    }
    @Override
    public Service selectServiceById(Integer id){
        return serviceDao.selectServiceById(id);
    }
    @Override
    public int insertService(Service value){
        return serviceDao.insertService(value);
    }
    @Override
    public int insertNonEmptyService(Service value){
        return serviceDao.insertNonEmptyService(value);
    }
    @Override
    public int deleteServiceById(Integer id){
        return serviceDao.deleteServiceById(id);
    }
    @Override
    public int deleteService(Assist assist){
        return serviceDao.deleteService(assist);
    }
    @Override
    public int updateServiceById(Service enti){
        return serviceDao.updateServiceById(enti);
    }
    @Override
    public int updateService(Service value, Assist assist){
        return serviceDao.updateService(value,assist);
    }
    @Override
    public int updateNonEmptyServiceById(Service enti){
        return serviceDao.updateNonEmptyServiceById(enti);
    }
    @Override
    public int updateNonEmptyService(Service value, Assist assist){
        return serviceDao.updateNonEmptyService(value,assist);
    }

    public ServiceDao getServiceDao() {
        return this.serviceDao;
    }

    public void setServiceDao(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

}