package com.elvis.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.elvis.models.OrderModel;
import com.elvis.models.SearchModel;
import com.elvis.services.OrdersBusinessServiceInterface;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	//dependency injection. 
	OrdersBusinessServiceInterface service;
	
	
	@Autowired
	public OrdersController(OrdersBusinessServiceInterface service) {
		super();
		this.service = service;
	}



	@GetMapping("/")
	public String showAllOrders(Model model) {
		
		List<OrderModel> orders = service.getOrders();
		
		
		
		model.addAttribute("title", "Here is what I want to do this summer");
		model.addAttribute("orders", orders);
		
		return "orders.html";
		
	}
	
	@GetMapping("/showNewOrderForm")
	public String showNewForm(Model model)
	{
		
		model.addAttribute("order", new OrderModel());
		
		return "addNewOrderForm.html";
	}
	
	

	@PostMapping("/addNew")
	public String addNew(@Valid OrderModel newOrder, BindingResult bindingResult, Model model )
	{
		
		//id number should be null, as id is auto generated in the DB
		newOrder.setId(null);
		
		//add to the database
		service.addOne(newOrder);
		
		//get all orders from database
		List<OrderModel> orders = service.getOrders();
		
		//show all orders page
		model.addAttribute("orders", orders);
		
		return "orders";
	}
	
	
	@GetMapping("/showSearchForm")
	public String showSearchForm(Model model)
	{
		
		model.addAttribute("searchModel", new SearchModel());
		
		return "searchForm.html";
	}
	
	
	@PostMapping("/search")
	public String search(@Valid SearchModel searchModel, BindingResult bindingResult, Model model)
	{
		String search  = searchModel.getSearchTerm();
		
		//get list of orders
		
		List<OrderModel> orders = service.searchOrders(search);
		
		
		//show all orders page
		model.addAttribute("orders", orders);
		
		
		return "orders";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
