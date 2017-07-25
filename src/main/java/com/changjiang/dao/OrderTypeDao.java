package com.changjiang.dao;
import com.changjiang.entity.OrderType;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface OrderTypeDao{
    long getOrderTypeRowCount(Assist assist);
    List<OrderType> selectOrderType(Assist assist);
    OrderType selectOrderTypeById(Integer id);
    int insertOrderType(OrderType value);
    int insertNonEmptyOrderType(OrderType value);
    int deleteOrderTypeById(Integer id);
    int deleteOrderType(Assist assist);
    int updateOrderTypeById(OrderType enti);
    int updateOrderType(@Param("enti") OrderType value, @Param("assist") Assist assist);
    int updateNonEmptyOrderTypeById(OrderType enti);
    int updateNonEmptyOrderType(@Param("enti") OrderType value, @Param("assist") Assist assist);
	/**
	 * 根据订单类型order_type查询订单信息db_order
	 * @param ordertypeid
	 * @return
	 */
    OrderType queryOrderInfoByOrderTypeId(Integer ordertypeid);
}