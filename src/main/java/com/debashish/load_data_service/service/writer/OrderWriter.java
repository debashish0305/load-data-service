package com.debashish.load_data_service.service.writer;

import com.debashish.load_data_service.config.LogExecutionTime;
import com.debashish.load_data_service.entity.OrderEntity;
import com.debashish.load_data_service.mapper.OrderMapper;
import com.debashish.load_data_service.model.Order;
import com.debashish.load_data_service.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderWriter implements ItemWriter<Order> {

	private final OrderRepository orderRepository;
	private final OrderMapper orderMapper;

	@LogExecutionTime
	@Override
	public void write(Chunk<? extends Order> items) {
		List<OrderEntity> entities = items.getItems().stream().map(orderMapper::toEntity).toList();
		orderRepository.saveAll(entities);
		log.info("Saved {} orders", entities.size());
	}
}