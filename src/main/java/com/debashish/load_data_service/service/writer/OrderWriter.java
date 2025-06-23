package com.debashish.load_data_service.service.writer;

import com.debashish.load_data_service.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

@Slf4j
public class OrderWriter implements ItemWriter<Order> {
	@Override
	public void write(Chunk<? extends Order> items) {
		for (Order item : items) {
			log.info("Writing item: {}", item);
		}
	}
}