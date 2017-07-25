package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.Service;
import com.changjiang.common.Assist;
public interface ServiceService{
    long getServiceRowCount(Assist assist);
    List<Service> selectService(Assist assist);
    Service selectServiceById(Integer id);
    int insertService(Service value);
    int insertNonEmptyService(Service value);
    int deleteServiceById(Integer id);
    int deleteService(Assist assist);
    int updateServiceById(Service enti);
    int updateService(Service value, Assist assist);
    int updateNonEmptyServiceById(Service enti);
    int updateNonEmptyService(Service value, Assist assist);
}