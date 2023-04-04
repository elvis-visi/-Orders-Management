package com.elvis.data;

import java.util.List;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.elvis.models.OrderModel;
import com.elvis.models.OrderEntity;

import org.modelmapper.ModelMapper;

public class OrdersDataServiceForRepository implements OrdersDataAccessInterface<OrderModel> {

	//need a data source
	@Autowired
	OrdersRepositoryInterface ordersRepository;
	
	private JdbcTemplate jdbcTemplate;
	
	public OrdersDataServiceForRepository(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	ModelMapper modelMapper =  new ModelMapper();
	
	@Override
	public OrderModel getById(long id) {
		
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
