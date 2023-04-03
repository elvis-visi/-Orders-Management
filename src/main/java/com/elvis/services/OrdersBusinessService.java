package com.elvis.services;

import java.util.ArrayList;
import java.util.List;

import com.elvis.models.OrderModel;


public class OrdersBusinessService implements OrdersBusinessServiceInterface {

	List<OrderModel> orders ;
	
	@Override
	public void test() {
		System.out.println("OrdersBusinessService is working");
		orders = new ArrayList<OrderModel>();
	}

	@Override
	public List<OrderModel> getOrders() {
	
		
		
		orders.add(new OrderModel(0L, "000","Sky diving exp", 1500.0f,1));
		orders.add(new OrderModel(1L, "001","car", 1500.0f,1));
		orders.add(new OrderModel(2L, "002","bike", 300.0f,111));
		orders.add(new OrderModel(3L, "003","boat", 100.0f,1));
		orders.add(new OrderModel(4L, "004","tennis", 4000.0f,2));
		orders.add(new OrderModel(5L, "005","gym", 1500.0f,3));
		
		
		return orders;
	}

	@Override
	public void init() {
		System.out.println("Init method of OrdersBusinessService");
		
	}

	@Override
	public void destroy() {
		System.out.println("Destroy method of OrdersBusinessService");
		
	}

}
