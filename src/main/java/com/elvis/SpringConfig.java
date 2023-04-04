package com.elvis;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.elvis.data.OrdersDataAccessInterface;
import com.elvis.services.OrdersBusinessService;
import com.elvis.services.OrdersBusinessServiceInterface;
import com.elvis.data.OrdersDataServiceForRepository;




//properties that the entire app will follow
@Configuration
public class SpringConfig {
	
	

	@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	@RequestScope
	public OrdersBusinessServiceInterface getOrdersBusiness() {
		return new OrdersBusinessService();
	}
	
	//form the application.properties
	@Autowired
	DataSource dataSource;
	
	@Bean(name="ordersDAO") 
	@RequestScope
	public OrdersDataAccessInterface getDataService() {
		return new OrdersDataServiceForRepository(dataSource);
		// return new OrdersDataService();
	}
	
}
