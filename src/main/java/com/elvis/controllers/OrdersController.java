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
	
	
	
	@GetMapping("/admin")
	public String showAdminPage(Model model)
	{
		
		List<OrderModel> orders = service.getOrders();
		
		
		model.addAttribute("title", "Here is what I want to do this summer");
		model.addAttribute("orders", orders);
		
		return "ordersAdmin.html";
	}
	
	
	
	@PostMapping("/doUpdate")
	//process a request from the AddOrderForm. Add a new order to the database. Show all orders
	public String updateOrder(@Valid OrderModel order, BindingResult bindingResult, Model model)
	{
		
		//add the new order
		service.updateOne(order.getId(), order);
		
		//get update list of all orders
		List<OrderModel> orders = service.getOrders();
		
		//display all orders
		model.addAttribute("orders",orders);
		
		return "orders.html";
		
		
	}
	
	
	@PostMapping("/editForm")
	public String displayEditForm(OrderModel orderModel,Model model)
	{
		
		//Display a new order form
		model.addAttribute("title", "Edit order");
		model.addAttribute("orderModel", orderModel);
		
		return "editForm.html";
	}
	
	@PostMapping("/delete")
	public String deelteOrder(OrderModel orderModel,Model model)
	{
		
		service.deleteOne(orderModel.getId());
		
		//get updated list of all orders
		List<OrderModel> orders = service.getOrders();
		
		//Display all orders
		model.addAttribute("orders", orders);
		
		return "ordersAdmin.html";
	}
	
	
	
	@GetMapping("/spa")
	public String showSPApage(Model model)
	{
		
		return "ordersSPA.html";
	}
	
	
	
	
	

}
