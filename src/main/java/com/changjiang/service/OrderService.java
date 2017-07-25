package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.Order;
import com.changjiang.common.Assist;
public interface OrderService{
    long getOrderRowCount(Assist assist);
    List<Order> selectOrder(Assist assist);
    Order selectOrderById(Integer id);
    int insertOrder(Order value);
    int insertNonEmptyOrder(Order value);
    int deleteOrderById(Integer id);
    int deleteOrder(Assist assist);
    int updateOrderById(Order enti);
    int updateOrder(Order value, Assist assist);
    int updateNonEmptyOrderById(Order enti);
    int updateNonEmptyOrder(Order value, Assist assist);
    /**
     * 查询所有订单信息
     * @return
     */
	List<Order> selectAllOrder();
	/**
	 * 该方法用来产生流水号
	 * @return
	 */
	public String createGlideNumber(SysCodeRuleService sysCodeRuleService);
	
}