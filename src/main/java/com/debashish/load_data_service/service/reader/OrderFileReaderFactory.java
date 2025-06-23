package com.debashish.load_data_service.service.reader;

import com.debashish.load_data_service.model.Order;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.core.io.FileSystemResource;

public class OrderFileReaderFactory {
	public static FlatFileItemReader<Order> create(String path, String fileName, String[] columns) {
		return new FlatFileItemReaderBuilder<Order>().name("csvReader-" + fileName)
				.resource(new FileSystemResource(path + fileName)).delimited().names(columns).targetType(Order.class)
				.linesToSkip(1).build();
	}
}