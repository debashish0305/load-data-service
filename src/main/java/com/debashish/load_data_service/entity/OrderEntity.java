package com.debashish.load_data_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "order_id")
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