package com.elvis.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.elvis.models.OrderModel;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@GetMapping("/")
	public String showAllOrders(Model model) {
		
		List<OrderModel> orders = new ArrayList<OrderModel>();
		
		orders.add(new OrderModel(0L, "000","Sky diving exp", 1500.0f,1));
		orders.add(new OrderModel(1L, "001","car", 1500.0f,1));
		orders.add(new OrderModel(2L, "002","bike", 300.0f,111));
		orders.add(new OrderModel(3L, "003","boat", 100.0f,1));
		orders.add(new OrderModel(4L, "004","tennis", 4000.0f,2));
		orders.add(new OrderModel(5L, "005","gym", 1500.0f,3));
		
		model.addAttribute("title", "Here is what I want to do this summer");
		model.addAttribute("orders", orders);
		
		return "orders.html";
		
	}
	
}
