package com.debashish.load_data_service.service.reader;

import com.debashish.load_data_service.model.Order;
import lombok.experimental.UtilityClass;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.core.io.FileSystemResource;

import java.util.List;
@UtilityClass
public class OrderFileReaderFactory {
	public static FlatFileItemReader<Order> create(String path, String fileName, List<String> columns) {
		return new FlatFileItemReaderBuilder<Order>().name("csvReader-" + fileName)
				.resource(new FileSystemResource(path + fileName)).delimited().names(columns.toArray(new String[0]))
				.targetType(Order.class).linesToSkip(1).build();
	}
}