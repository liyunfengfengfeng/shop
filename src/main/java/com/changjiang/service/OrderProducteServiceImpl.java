package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.OrderProducteDao;
import com.changjiang.entity.OrderProducte;
import com.changjiang.common.Assist;
@Service
public class OrderProducteServiceImpl implements OrderProducteService{
    @Autowired
	private OrderProducteDao orderProducteDao;
    @Override
    public long getOrderProducteRowCount(Assist assist){
        return orderProducteDao.getOrderProducteRowCount(assist);
    }
    @Override
    public List<OrderProducte> selectOrderProducte(Assist assist){
        return orderProducteDao.selectOrderProducte(assist);
    }
    @Override
    public OrderProducte selectOrderProducteById(Integer id){
        return orderProducteDao.selectOrderProducteById(id);
    }
    @Override
    public int insertOrderProducte(OrderProducte value){
        return orderProducteDao.insertOrderProducte(value);
    }
    @Override
    public int insertNonEmptyOrderProducte(OrderProducte value){
        return orderProducteDao.insertNonEmptyOrderProducte(value);
    }
    @Override
    public int deleteOrderProducteById(Integer id){
        return orderProducteDao.deleteOrderProducteById(id);
    }
    @Override
    public int deleteOrderProducte(Assist assist){
        return orderProducteDao.deleteOrderProducte(assist);
    }
    @Override
    public int updateOrderProducteById(OrderProducte enti){
        return orderProducteDao.updateOrderProducteById(enti);
    }
    @Override
    public int updateOrderProducte(OrderProducte value, Assist assist){
        return orderProducteDao.updateOrderProducte(value,assist);
    }
    @Override
    public int updateNonEmptyOrderProducteById(OrderProducte enti){
        return orderProducteDao.updateNonEmptyOrderProducteById(enti);
    }
    @Override
    public int updateNonEmptyOrderProducte(OrderProducte value, Assist assist){
        return orderProducteDao.updateNonEmptyOrderProducte(value,assist);
    }

    public OrderProducteDao getOrderProducteDao() {
        return this.orderProducteDao;
    }

    public void setOrderProducteDao(OrderProducteDao orderProducteDao) {
        this.orderProducteDao = orderProducteDao;
    }

}