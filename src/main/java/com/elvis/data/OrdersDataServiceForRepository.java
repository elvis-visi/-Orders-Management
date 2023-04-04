package com.elvis.data;

import java.util.List;

import com.elvis.models.OrderModel;

public class OrdersDataServiceForRepository implements OrdersDataAccessInterface<OrderModel> {

	@Override
	public OrderModel getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long addOne(OrderModel newOrder) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteOne(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
