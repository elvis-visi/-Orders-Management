package com.elvis.services;

import java.util.List;

import com.elvis.models.OrderModel;

public interface OrdersBusinessServiceInterface {
	
	public void test();
	
	public List<OrderModel> getOrders();
	
	public void init();
	
	public void destroy();
	
	//future methods
	
	// searchOrders(String searchItem)
	
	//addOrder(OrderModel new0)
	
	//deleteOrder(Long id)
	
	//updateOrder(OrderModel updateMe)#
	
	
	//getOneOrder(Long id)

}
