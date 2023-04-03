package com.elvis.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.elvis.models.OrderModel;

@Service
public class OrdersBusinessService implements OrdersBusinessServiceInterface {

	@Override
	public void test() {
		System.out.println("OrdersBusinessService is working");
	}

	@Override
	public List<OrderModel> getOrders() {
	
		List<OrderModel> orders = new ArrayList<OrderModel>();
		
		orders.add(new OrderModel(0L, "000","Sky diving exp", 1500.0f,1));
		orders.add(new OrderModel(1L, "001","car", 1500.0f,1));
		orders.add(new OrderModel(2L, "002","bike", 300.0f,111));
		orders.add(new OrderModel(3L, "003","boat", 100.0f,1));
		orders.add(new OrderModel(4L, "004","tennis", 4000.0f,2));
		orders.add(new OrderModel(5L, "005","gym", 1500.0f,3));
		
		
		return orders;
	}

}
