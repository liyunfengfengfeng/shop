package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.OrderTypeDao;
import com.changjiang.entity.OrderType;
import com.changjiang.common.Assist;
@Service
public class OrderTypeServiceImpl implements OrderTypeService{
    @Autowired
	private OrderTypeDao orderTypeDao;
    @Override
    public long getOrderTypeRowCount(Assist assist){
        return orderTypeDao.getOrderTypeRowCount(assist);
    }
    @Override
    public List<OrderType> selectOrderType(Assist assist){
        return orderTypeDao.selectOrderType(assist);
    }
    @Override
    public OrderType selectOrderTypeById(Integer id){
        return orderTypeDao.selectOrderTypeById(id);
    }
    @Override
    public int insertOrderType(OrderType value){
        return orderTypeDao.insertOrderType(value);
    }
    @Override
    public int insertNonEmptyOrderType(OrderType value){
        return orderTypeDao.insertNonEmptyOrderType(value);
    }
    @Override
    public int deleteOrderTypeById(Integer id){
        return orderTypeDao.deleteOrderTypeById(id);
    }
    @Override
    public int deleteOrderType(Assist assist){
        return orderTypeDao.deleteOrderType(assist);
    }
    @Override
    public int updateOrderTypeById(OrderType enti){
        return orderTypeDao.updateOrderTypeById(enti);
    }
    @Override
    public int updateOrderType(OrderType value, Assist assist){
        return orderTypeDao.updateOrderType(value,assist);
    }
    @Override
    public int updateNonEmptyOrderTypeById(OrderType enti){
        return orderTypeDao.updateNonEmptyOrderTypeById(enti);
    }
    @Override
    public int updateNonEmptyOrderType(OrderType value, Assist assist){
        return orderTypeDao.updateNonEmptyOrderType(value,assist);
    }

    public OrderTypeDao getOrderTypeDao() {
        return this.orderTypeDao;
    }

    public void setOrderTypeDao(OrderTypeDao orderTypeDao) {
        this.orderTypeDao = orderTypeDao;
    }
    /**
     * 根据订单类型order_type查询订单信息db_order
     */
	@Override
	public OrderType queryOrderInfoByOrderTypeId(Integer ordertypeid) {
		// TODO Auto-generated method stub
		return orderTypeDao.queryOrderInfoByOrderTypeId(ordertypeid);
	}

}