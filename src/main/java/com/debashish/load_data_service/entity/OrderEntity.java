package com.debashish.load_data_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "orders", schema = "load_data_service")
@Data
public class OrderEntity extends BaseEntity {

	@Column(name = "order_id")
	private String orderId;
	@Column(name = "name")
	private String name;
	@Column(name = "value")
	private String value;
	@Column(name = "customer")
	private String customer;
	@Column(name = "product")
	private String product;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "price")
	private Double price;
	@Column(name = "discount")
	private Double discount;
	@Column(name = "shipping_address")
	private String shippingAddress;
	@Column(name = "billing_address")
	private String billingAddress;
	@Column(name = "order_date")
	private String orderDate;
	@Column(name = "delivery_date")
	private String deliveryDate;
	@Column(name = "payment_status")
	private String paymentStatus;
}