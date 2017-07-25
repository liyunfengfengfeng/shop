package com.changjiang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changjiang.common.Assist;
import com.changjiang.entity.Order;
import com.changjiang.entity.OrderType;
import com.changjiang.service.OrderTypeService;

/**
 * 
 * 订单类型控制层
 */
@Controller
public class OrderTypeController {
	@Autowired
	private OrderTypeService ordertypeservice;
	/**
	 * 查询所有的订单类型信息
	 */
	@RequestMapping(value="/queryordertypewithnocondition")
	public String queryAllOrders(){
		System.out.println("ordertypeservice is :" + ordertypeservice);
		Assist assist = new Assist();
		List<OrderType> ordertypes = ordertypeservice.selectOrderType(assist);
		System.out.println("ordertypes.size() :" + ordertypes.size());
		return "index";
	}
	
	/**
	 * 根据id删除订单类型信息
	 * 当有外键约束无法删除时,先删除依附该外键的数据
	 */
	@RequestMapping(value="/deleteordertypebyid/{ordertypeid}")
	public String deleteOrderById(@PathVariable("ordertypeid") Integer ordertypeid){
		System.out.println("ordertypeservice is :" + ordertypeservice);
		int del_num = ordertypeservice.deleteOrderTypeById(ordertypeid);
		System.out.println("del_num is :" + del_num);
		return "index";
	}
	
	/**
	 * 添加订单类型信息
	 */
	@RequestMapping(value="/addordertype")
	public String addOrderType(){
		System.out.println("ordertypeservice is :" + ordertypeservice);
		OrderType orderType = new OrderType();
		orderType.setDbDesc("testdesc");
		int add_num = ordertypeservice.insertNonEmptyOrderType(orderType);
		System.out.println("add_num is :" + add_num);
		return "index";
	}
	
	/**
	 * 更新订单信息
	 */
	@RequestMapping(value="/updateordertypebyid")
	public String updateOrderTypeById(){
		System.out.println("ordertypeservice is :" + ordertypeservice);
		OrderType orderType = new OrderType();
		orderType.setDbDesc("testdesc0000000");
		orderType.setId(3);
		orderType.setName("test");
		orderType.setState("0");
		orderType.setStoreNumber("111111");
		int upd_num = ordertypeservice.updateNonEmptyOrderTypeById(orderType);
		System.out.println("upd_num is :" + upd_num);
		return "index";
	}
	/**
	 * 根据订单类型order_type查询订单信息db_order
	 */
	@RequestMapping("/queryorderinfobyordertypeid/{ordertypeid}")
	public String queryOrderInfoByOrderTypeId(@PathVariable Integer ordertypeid){
		System.out.println("ordertypeservice is :" + ordertypeservice);
		OrderType orderType = ordertypeservice.queryOrderInfoByOrderTypeId(ordertypeid);
		if(orderType != null ){
			System.out.println("orderType.getDbDesc()  :" + orderType.getDbDesc());
			List<Order> orders = orderType.getOrders();
			if(orders != null && orders.size() > 0){
				System.out.println("orders.size()  :" + orders.size());
			}
		}
		return "index";
	}
}
