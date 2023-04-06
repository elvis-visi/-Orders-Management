package com.elvis.data;

import java.util.List;
import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;


import com.elvis.models.OrderModel;
import com.elvis.models.OrderEntity;

import org.modelmapper.ModelMapper;

public class OrdersDataServiceForRepository implements OrdersDataAccessInterface<OrderModel> {

	//need a data source
	@Autowired
	OrdersRepositoryInterface ordersRepository;
	

	
	
	ModelMapper modelMapper =  new ModelMapper();
	
	@Override
	public OrderModel getById(String id) {
		
		OrderEntity entity = ordersRepository.findById(id).orElse(null);
		
		/*OrderModel model = new OrderModel(
				entity.getId(),
				entity.getOrderNo(),
				entity.getProductName(),
				entity.getPrice(),
				entity.getQuantity()
				);
		*/
		//mapping all different fields from OrderEntity to OrderModel
		OrderModel model = modelMapper.map(entity,OrderModel.class);
		
		return model;
	}

	@Override
	public List<OrderModel> getOrders() {
	
		Iterable<OrderEntity>  ordersEntity = ordersRepository.findAll();
		
		List<OrderModel> models = new ArrayList<OrderModel>();
		
		for(OrderEntity item: ordersEntity) {
			// add item to the list of ordermodel
			models.add(modelMapper.map(item, OrderModel.class));
		}
		
		return models;
	}

	

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		
		 List<OrderEntity>	ordersEntity = 
	ordersRepository.findByProductName(searchTerm);
		
		 List<OrderModel> orders = new ArrayList<OrderModel>();
			
			for(OrderEntity item: ordersEntity) {
				// add item to the list of ordermodel
				orders.add(modelMapper.map(item, OrderModel.class));
			}
			return orders;
	}

	@Override
	public String addOne(OrderModel newOrder) {
		//we can save OrderEntity to the DB
		OrderEntity entity = modelMapper.map(newOrder,OrderEntity.class);
		OrderEntity result = ordersRepository.save(entity);
		
		if(result == null)
		{
			return null;
		}else {
			return result.getId();
		}
		
	}

	@Override
	public boolean deleteOne(String id) {
		
		ordersRepository.deleteById(id);
		return true;
	}

	@Override
	public OrderModel updateOne(String idToUpdate, OrderModel updateOrder) {
		
		OrderEntity entity = modelMapper.map(updateOrder,OrderEntity.class);
		OrderEntity result = ordersRepository.save(entity);
		
		OrderModel order = modelMapper.map(result,OrderModel.class);
		
	
		return order;
	}

	

}
