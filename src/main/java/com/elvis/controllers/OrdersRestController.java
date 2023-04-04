package com.elvis.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.elvis.models.OrderModel;
import com.elvis.services.OrdersBusinessServiceInterface;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersRestController {
	
	//dependency injection. 
	OrdersBusinessServiceInterface service;
	
	
	@Autowired
	public OrdersRestController(OrdersBusinessServiceInterface service) {
		super();
		this.service = service;
	}


	//serve JSON data
	@GetMapping("/")
	public List<OrderModel> showAllOrders() {
		
		List<OrderModel> orders = service.getOrders();
		
		
	
		return orders;
		
	}
	
	@GetMapping("/search/{searchTerm}")
	public List<OrderModel> searchOrders(@PathVariable(name="searchTerm") String searchTerm) {
		
		List<OrderModel> orders = service.searchOrders(searchTerm);
		
		
	
		return orders;
		
	}
	
	
	@PostMapping("/")
	public long addOrder(@RequestBody OrderModel model)
	{
		return service.addOne(model);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
