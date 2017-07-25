package com.changjiang.dao;
import com.changjiang.entity.ServiceType;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface ServiceTypeDao{
    long getServiceTypeRowCount(Assist assist);
    List<ServiceType> selectServiceType(Assist assist);
    ServiceType selectServiceTypeById(Integer id);
    int insertServiceType(ServiceType value);
    int insertNonEmptyServiceType(ServiceType value);
    int deleteServiceTypeById(Integer id);
    int deleteServiceType(Assist assist);
    int updateServiceTypeById(ServiceType enti);
    int updateServiceType(@Param("enti") ServiceType value, @Param("assist") Assist assist);
    int updateNonEmptyServiceTypeById(ServiceType enti);
    int updateNonEmptyServiceType(@Param("enti") ServiceType value, @Param("assist") Assist assist);
}