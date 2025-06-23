package com.debashish.load_data_service.service.processor;

import com.debashish.load_data_service.model.Order;
import org.springframework.batch.item.ItemProcessor;

public class OrderProcessor implements ItemProcessor<Order, Order> {
	@Override
	public Order process(Order item) {
		// Add processing logic if needed
		return item;
	}
}