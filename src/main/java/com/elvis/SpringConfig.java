package com.elvis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.elvis.data.OrdersDataAccessInterface;
import com.elvis.data.OrdersDataService;
import com.elvis.services.OrdersBusinessService;
import com.elvis.services.OrdersBusinessServiceInterface;

//properties that the entire app will follow
@Configuration
public class SpringConfig {

	@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	@RequestScope
	public OrdersBusinessServiceInterface getOrdersBusiness() {
		return new OrdersBusinessService();
	}
	
	@Bean(name="ordersDAO")
	@RequestScope
	public OrdersDataAccessInterface getDataService() {
		return new OrdersDataService();
	}
	
}
