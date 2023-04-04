package com.elvis.data;

import org.springframework.data.repository.CrudRepository;

import com.elvis.models.OrderEntity;

public interface OrdersRepositoryInterface extends CrudRepository<OrderEntity,Long>{

	// use the CrudRepository class in Spring to do the data operations on mysql
	
	
	
}
