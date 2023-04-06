package com.elvis.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.elvis.data.OrdersDataAccessInterface;
import com.elvis.models.OrderModel;


public class OrdersBusinessService implements OrdersBusinessServiceInterface {

	@Autowired
	 @Qualifier("ordersDAO")
	 OrdersDataAccessInterface<OrderModel> ordersDAO;
	
	
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

	@Override
	public OrderModel getById(String id) {
		
		return ordersDAO.getById(id);
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
	
		return ordersDAO.searchOrders(searchTerm);
	}

	@Override
	public String addOne(OrderModel newOrder) {
		
		return ordersDAO.addOne(newOrder);
	}

	@Override
	public boolean deleteOne(String id) {
		
		return ordersDAO.deleteOne(id);
	}

	@Override
	public OrderModel updateOne(String idToUpdate, OrderModel updateOrder) {
		
		return ordersDAO.updateOne(idToUpdate, updateOrder);
	}

}
