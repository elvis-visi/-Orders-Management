package com.elvis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.elvis.services.OrdersBusinessService;
import com.elvis.services.OrdersBusinessService2;
import com.elvis.services.OrdersBusinessServiceInterface;

//properties that the entire app will follow
@Configuration
public class SpringConfig {

	@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	@RequestScope
	public OrdersBusinessServiceInterface getOrdersBusiness() {
		return new OrdersBusinessService2();
	}
	
}
