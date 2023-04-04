package com.elvis.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.elvis.models.OrderModel;

@Repository
public class OrdersFakeDAO implements OrdersDataAccessInterface<OrderModel> {

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
		
		//if list contains an order with the id above return it
		
		for(OrderModel order : orders)
		{
			if(order.getId() == id)
			{
				return order;
			}
		}
		
		return null;
	}

	@Override
	public List<OrderModel> getOrders() {
	
		return orders;
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		
		List<OrderModel> foundItems = orders
				.stream()
				.filter(order -> order.getProductName().toLowerCase()
						.contains(searchTerm.toLowerCase()))
				.collect(Collectors.toList());		
		
		return foundItems;
	}

	@Override
	public long addOne(OrderModel newOrder) {
		
		boolean success = orders.add(newOrder);
		
		if(success)
		{
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public boolean deleteOne(long id) {
		
		for(OrderModel order : orders)
		{
			if(order.getId() == id)
			{
				orders.remove(order);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {

		for(int i =0; i <orders.size(); i++)
		{
			if(orders.get(i).getId() == idToUpdate)	
			{
				orders.set(i, updateOrder);
				return orders.get(i);
			}
		}
		return null;
	}

}
