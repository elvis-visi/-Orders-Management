package com.elvis.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.elvis.models.OrderEntity;

public interface OrdersRepositoryInterface extends MongoRepository<OrderEntity, String> {

	 // use the CrudRepository class in Spring to do the data operations on mysql
	// already implies that we will use save, findall, findbyid, deletebyid etc.
	
	// ?0 corresponds to searchTerm. $options':'i'  -->  ignore case
	@Query("{'productName':{'$regex':'?0', '$options':'i'}}") 
	List<OrderEntity> findByProductName(String searchTerm);
	
}
