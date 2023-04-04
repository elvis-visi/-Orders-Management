package com.elvis.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import  com.elvis.models.OrdersMapper;

import com.elvis.models.OrderModel;

@Repository
public class OrdersDataService implements OrdersDataAccessInterface {

	//connection to the DB, application.properties file to get the detail on the 
	//mysql connection
	@Autowired
	DataSource dataSource;
	
	//used to execute sql statements
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public OrderModel getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> getOrders() {
		//sql statement and some kind of object mapper
		List<OrderModel> results = jdbcTemplate.query("SELECT * FROM ORDERS", new OrdersMapper());
		
		return results;
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
