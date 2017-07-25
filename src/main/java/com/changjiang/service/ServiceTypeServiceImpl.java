package com.changjiang.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.changjiang.dao.ServiceTypeDao;
import com.changjiang.entity.ServiceType;
import com.changjiang.common.Assist;
@Service
public class ServiceTypeServiceImpl implements ServiceTypeService{
    private ServiceTypeDao serviceTypeDao;
    @Override
    public long getServiceTypeRowCount(Assist assist){
        return serviceTypeDao.getServiceTypeRowCount(assist);
    }
    @Override
    public List<ServiceType> selectServiceType(Assist assist){
        return serviceTypeDao.selectServiceType(assist);
    }
    @Override
    public ServiceType selectServiceTypeById(Integer id){
        return serviceTypeDao.selectServiceTypeById(id);
    }
    @Override
    public int insertServiceType(ServiceType value){
        return serviceTypeDao.insertServiceType(value);
    }
    @Override
    public int insertNonEmptyServiceType(ServiceType value){
        return serviceTypeDao.insertNonEmptyServiceType(value);
    }
    @Override
    public int deleteServiceTypeById(Integer id){
        return serviceTypeDao.deleteServiceTypeById(id);
    }
    @Override
    public int deleteServiceType(Assist assist){
        return serviceTypeDao.deleteServiceType(assist);
    }
    @Override
    public int updateServiceTypeById(ServiceType enti){
        return serviceTypeDao.updateServiceTypeById(enti);
    }
    @Override
    public int updateServiceType(ServiceType value, Assist assist){
        return serviceTypeDao.updateServiceType(value,assist);
    }
    @Override
    public int updateNonEmptyServiceTypeById(ServiceType enti){
        return serviceTypeDao.updateNonEmptyServiceTypeById(enti);
    }
    @Override
    public int updateNonEmptyServiceType(ServiceType value, Assist assist){
        return serviceTypeDao.updateNonEmptyServiceType(value,assist);
    }

    public ServiceTypeDao getServiceTypeDao() {
        return this.serviceTypeDao;
    }

    public void setServiceTypeDao(ServiceTypeDao serviceTypeDao) {
        this.serviceTypeDao = serviceTypeDao;
    }

}