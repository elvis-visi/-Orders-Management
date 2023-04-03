package com.elvis.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.elvis.models.OrderModel;


public class OrdersBusinessService2 implements OrdersBusinessServiceInterface {

	@Override
	public void test() {
		System.out.println("OrdersBusinessService is working");
	}

	@Override
	public List<OrderModel> getOrders() {
	
		List<OrderModel> orders = new ArrayList<OrderModel>();
		
		orders.add(new OrderModel(0L, "AAA","big mac", 1500.0f,1));
		orders.add(new OrderModel(1L, "AAB","chicken", 1500.0f,1));
		orders.add(new OrderModel(2L, "AAC","fries", 300.0f,111));
		orders.add(new OrderModel(3L, "AAD","sandwich", 100.0f,1));
		orders.add(new OrderModel(4L, "AAE","hotdog", 4000.0f,2));
		orders.add(new OrderModel(5L, "AAF","milkshake", 1500.0f,3));
		
		
		return orders;
	}
	
	@Override
	public void init() {
		System.out.println("Init method of OrdersBusinessService2");
		
	}

	@Override
	public void destroy() {
		System.out.println("Destroy method of OrdersBusinessService2");
		
	}

}
