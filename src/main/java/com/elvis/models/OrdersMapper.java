package com.elvis.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrdersMapper implements RowMapper<OrderModel> {

	//ResultSet the data that comes from the DB
	//we will take sth that comes from the Db and interpret it into a model
	@Override
	public OrderModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		//get the result set
		
		//create a new order object
		
		//return it
		
		OrderModel order = new OrderModel(rs.getLong("ID"), rs.getString("ORDER_NUMBER"),
				rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE"), rs.getInt("QTY"));
		
		return order;
	}

	
	
	
}
