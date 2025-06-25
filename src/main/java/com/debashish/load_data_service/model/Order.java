package com.debashish.load_data_service.model;

import lombok.Data;

@Data
public class Order {
	private String orderId;
	private String name;
	private String value;
	private String customer;
	private String product;
	private Integer quantity;
	private Double price;
	private Double discount;
	private String shippingAddress;
	private String billingAddress;
	private String orderDate;
	private String deliveryDate;
	private String paymentStatus;
}