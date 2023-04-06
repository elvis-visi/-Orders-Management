package com.elvis.data;

import java.util.List;

import com.elvis.models.OrderModel;

public interface OrdersDataAccessInterface <T> {
	
	public T getById(String id);
	public List<T> getOrders();
	public List<T> searchOrders(String searchTerm);
	
	public String addOne(T newOrder);
	
	public boolean deleteOne(String id);
	
	public T updateOne(String idToUpdate,T updateOrder);

}
