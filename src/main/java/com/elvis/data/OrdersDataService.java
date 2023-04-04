package com.elvis.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import  com.elvis.models.OrdersMapper;

import com.elvis.models.OrderModel;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrdersDataService implements OrdersDataAccessInterface<OrderModel> {

	//connection to the DB, application.properties file to get the detail on the 
	//mysql connection
	@Autowired
	DataSource dataSource;
	
	//used to execute sql statements
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public OrderModel getById(long id) {
		
		
	List<OrderModel> results = jdbcTemplate.query("SELECT * FROM ORDERS WHERE ID = ?",new OrdersMapper(), id);
		
		if(results.size() > 0)
		{
			return results.get(0);
		}else
			
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
		//"%" + searchTerm + "%" wildcard allows us to search for patial names
		List<OrderModel> results = jdbcTemplate.query("SELECT * FROM ORDERS WHERE PRODUCT_NAME LIKE ?", new OrdersMapper(),"%" + searchTerm + "%");
		
		return results;
	}

	@Override
	public long addOne(OrderModel newOrder) {
		// newOrder is an object that is supposed to be inserted into the database
		
		//should return a long value as the id number of the new item in the db.
		
		//update -> sql statement and an object
		//Question marks placeholders to avoid SQL injection attacks
		
		/*long result = jdbcTemplate.update("INSERT INTO ORDERS (ORDER_NUMBER,PRODUCT_NAME,PRICE,QTY) VALUES (?,?,?,?)", 
				newOrder.getOrderNo(),
				newOrder.getProductName(),
				newOrder.getPrice(),
				newOrder.getQuantity()
				);
		
		return result;   */
		
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);
		
		//generateKeyColumns because we are using AI
		simpleInsert.withTableName("ORDERS").usingGeneratedKeyColumns("ID");
		
		
		// columns name - corresponding column's value
		 Map<String, Object> parameters = new HashMap<String, Object>();
		
		 parameters.put("ORDER_NUMBER", newOrder.getOrderNo());
		 parameters.put("PRODUCT_NAME", newOrder.getProductName());
		 parameters.put("PRICE", newOrder.getPrice());
		 parameters.put("QTY", newOrder.getQuantity());
		 
		 //return the generated key
		 Number result =  simpleInsert.executeAndReturnKey(parameters);
		 
		 return result.longValue();
	}

	@Override
	public boolean deleteOne(long id) {
		//returns number of rows affected
		int result = jdbcTemplate.update("DELETE FROM ORDERS WHERE ID= ?", id);
		
		if(result > 0)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		
	int result = 	jdbcTemplate.update("UPDATE ORDERS SET ORDER_NUMBER = ?, PRODUCT_NAME = ?, PRICE = ?, QTY = ? WHERE ID = ?",
				updateOrder.getOrderNo(),
				updateOrder.getProductName(),
				updateOrder.getPrice(),
				updateOrder.getQuantity(),
				idToUpdate);
		
	if(result > 0)
	{
		return updateOrder;
	}else
	
		return null;
	}

}
