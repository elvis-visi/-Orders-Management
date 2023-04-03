package com.elvis.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.elvis.models.OrderModel;

@Repository
public class OrdersFakeDAO implements OrdersDataAccessInterface {

	List<OrderModel> orders = new ArrayList<OrderModel>(); ;
	
	
	
	public OrdersFakeDAO() {
		orders.add(new OrderModel(0L, "000","Sky diving exp", 1500.0f,1));
		orders.add(new OrderModel(1L, "001","car", 1500.0f,1));
		orders.add(new OrderModel(2L, "002","bike", 300.0f,111));
		orders.add(new OrderModel(3L, "003","boat", 100.0f,1));
		orders.add(new OrderModel(4L, "004","tennis", 4000.0f,2));
		orders.add(new OrderModel(5L, "005","gym", 1500.0f,3));
	}

	@Override
	public OrderModel getById(long id) {
		
		return null;
	}

	@Override
	public List<OrderModel> getOrders() {
	
		return orders;
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		
		List<OrderModel> foundItems = new ArrayList<OrderModel>(); ;
		
		//given a search term. create a list of items whose descriptions match
		
		for(int i = 0 ; i <orders.size(); i++)
		{
			if(orders.get(i).getProductName().toLowerCase().contains(searchTerm.toLowerCase()))
			{
				foundItems.add(orders.get(i));
			}
		}
		
		return foundItems;
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
