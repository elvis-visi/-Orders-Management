package com.elvis.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.elvis.models.OrderModel;
import com.elvis.services.OrdersBusinessService;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	//dependency injection. 
	@Autowired
	OrdersBusinessService service;

	@GetMapping("/")
	public String showAllOrders(Model model) {
		
		List<OrderModel> orders = service.getOrders();
		
		
		
		model.addAttribute("title", "Here is what I want to do this summer");
		model.addAttribute("orders", orders);
		
		return "orders.html";
		
	}
	
}
