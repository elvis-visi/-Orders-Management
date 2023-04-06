package com.elvis.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="orders")
public class OrderEntity {
	
	//OrderEntity is based on OrderModel
	//Its purpose is to connect the OrderModel to the Orders table in the database.
	
	@Id
	String id;
	
	@Indexed(unique=true)
	String orderNo = "";
	
	@Indexed(unique=true)
	String productName = "";
	
	float price = 0;
	
	int quantity = 0;
	
	//we need a parameterless constructor for the mapping library we will use later.
	public OrderEntity()
	{
		
	}
	
	
	public OrderEntity(String id, String orderNo, String productName, float price, int quantity) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderModel [id=" + id + ", orderNo=" + orderNo + ", productName=" + productName + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	
	

}
