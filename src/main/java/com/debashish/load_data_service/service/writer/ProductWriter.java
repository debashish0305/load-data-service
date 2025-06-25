package com.debashish.load_data_service.service.writer;

import com.debashish.load_data_service.config.LogExecutionTime;
import com.debashish.load_data_service.entity.ProductEntity;
import com.debashish.load_data_service.mapper.ProductMapper;
import com.debashish.load_data_service.model.Product;
import com.debashish.load_data_service.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductWriter implements ItemWriter<Product> {
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	@LogExecutionTime
	@Override
	public void write(Chunk<? extends Product> items) {
		List<ProductEntity> entities = items.getItems().stream().map(productMapper::toEntity).toList();
		productRepository.saveAll(entities);
		log.info("Saved {} products", entities.size());
	}
}