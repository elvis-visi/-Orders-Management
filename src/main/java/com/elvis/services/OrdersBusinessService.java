package com.elvis.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.elvis.data.OrdersDataAccessInterface;
import com.elvis.models.OrderModel;


public class OrdersBusinessService implements OrdersBusinessServiceInterface {

	@Autowired
	 OrdersDataAccessInterface ordersDAO;
	
	
	@Override
	public void test() {
		System.out.println("OrdersBusinessService is working");
	
	}

	@Override
	public List<OrderModel> getOrders() {
	
	
		return ordersDAO.getOrders();
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
