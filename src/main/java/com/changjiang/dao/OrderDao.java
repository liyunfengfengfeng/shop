package com.changjiang.dao;
import com.changjiang.entity.Order;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface OrderDao{
    long getOrderRowCount(Assist assist);
    List<Order> selectOrder(Assist assist);
    Order selectOrderById(Integer id);
    int insertOrder(Order value);
    int insertNonEmptyOrder(Order value);
    int deleteOrderById(Integer id);
    int deleteOrder(Assist assist);
    int updateOrderById(Order enti);
    int updateOrder(@Param("enti") Order value, @Param("assist") Assist assist);
    int updateNonEmptyOrderById(Order enti);
    int updateNonEmptyOrder(@Param("enti") Order value, @Param("assist") Assist assist);
	/**
	 * 查询所有订单信息
	 * @return
	 */
    List<Order> selectAllOrder();
}