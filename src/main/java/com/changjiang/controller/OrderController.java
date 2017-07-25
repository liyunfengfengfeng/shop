package com.changjiang.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changjiang.entity.Order;
import com.changjiang.service.OrderService;

/**
 * 
 * 订单控制层
 *
 */
@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	/**
	 * 查询所有的订单表
	 */
	@RequestMapping(value="/queryorderswithnocondition")
	public String queryAllOrders(){
		System.out.println("orderService is :" + orderService);
		//order表关键字冲突
		List<Order> orders = orderService.selectAllOrder();
		System.out.println("orders.size() :" + orders.size());
		return "index";
	}
	
	/**
	 * 根据id删除订单信息
	 */
	@RequestMapping(value="/deleteorderbyid/{orderid}")
	public String deleteOrderById(@PathVariable("orderid") Integer orderid){
		System.out.println("orderService is :" + orderService);
		int del_num = orderService.deleteOrderById(orderid);
		System.out.println("del_num is :" + del_num);
		return "index";
	}
	
	/**
	 * 添加订单信息
	 */
	@RequestMapping(value="/addorderbyid")
	public String addOrderById(){
		System.out.println("orderService is :" + orderService);
		Order order = new Order();
		order.setCheckoutTime(new Date());
		order.setCounterId(1);
        order.setNumber("123465");
        order.setOneBillForAllId(11);
        order.setOperatorId(1);
        order.setReminderNumber(12);
		int del_num = orderService.insertNonEmptyOrder(order);
		System.out.println("del_num is :" + del_num);
		return "index";
	}
	
	/**
	 * 更新订单信息
	 */
	@RequestMapping(value="/updateorderbyid")
	public String updateOrderById(){
		System.out.println("orderService is :" + orderService);
		Order order = new Order();
		order.setCheckoutTime(new Date());
		order.setId(1);
		order.setCounterId(1);
        order.setNumber("0000000");
        order.setOneBillForAllId(11);
        order.setOperatorId(1);
        order.setReminderNumber(00);
		int del_num = orderService.insertNonEmptyOrder(order);
		System.out.println("del_num is :" + del_num);
		return "index";
	}
	
	
	
}
