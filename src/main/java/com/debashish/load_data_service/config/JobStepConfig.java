package com.debashish.load_data_service.config;

import com.debashish.load_data_service.model.Order;
import com.debashish.load_data_service.model.Product;
import com.debashish.load_data_service.model.User;
import com.debashish.load_data_service.service.processor.OrderProcessor;
import com.debashish.load_data_service.service.processor.ProductProcessor;
import com.debashish.load_data_service.service.processor.UserProcessor;
import com.debashish.load_data_service.service.reader.OrderFileReaderFactory;
import com.debashish.load_data_service.service.reader.ProductFileReaderFactory;
import com.debashish.load_data_service.service.reader.UserFileReaderFactory;
import com.debashish.load_data_service.service.writer.OrderWriter;
import com.debashish.load_data_service.service.writer.ProductWriter;
import com.debashish.load_data_service.service.writer.UserWriter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import static com.debashish.load_data_service.constants.Constants.*;

@Configuration
public class JobStepConfig {

	@Value("${app.input-folder}")
	private String inputFolder;

	static final String[] ORDER_COLUMNS = {"id", "name", "value"};
	static final String[] USER_COLUMNS = {"id", "name", "value"};
	static final String[] PRODUCT_COLUMNS = {"id", "name", "value"};

	@Bean(BEAN_USER_STEP)
	public Step userStep(JobRepository jobRepository, PlatformTransactionManager txManager, UserProcessor userProcessor,
			UserWriter userWriter) {
		return new StepBuilder("step-USERS", jobRepository).<User, User>chunk(100, txManager)
				.reader(UserFileReaderFactory.create(inputFolder, USERS_CSV_FILE, USER_COLUMNS))
				.processor(userProcessor).writer(userWriter).build();
	}

	@Bean(BEAN_ORDER_STEP)
	public Step orderStep(JobRepository jobRepository, PlatformTransactionManager txManager,
			OrderProcessor orderProcessor, OrderWriter orderWriter) {
		return new StepBuilder("step-ORDERS", jobRepository).<Order, Order>chunk(100, txManager)
				.reader(OrderFileReaderFactory.create(inputFolder, ORDERS_CSV_FILE, ORDER_COLUMNS))
				.processor(orderProcessor).writer(orderWriter).build();
	}

	@Bean(BEAN_PRODUCT_STEP)
	public Step productStep(JobRepository jobRepository, PlatformTransactionManager txManager,
			ProductProcessor productProcessor, ProductWriter productWriter) {
		return new StepBuilder("step-PRODUCTS", jobRepository).<Product, Product>chunk(100, txManager)
				.reader(ProductFileReaderFactory.create(inputFolder, PRODUCTS_CSV_FILE, PRODUCT_COLUMNS))
				.processor(productProcessor).writer(productWriter).build();
	}

	// processors
	@Bean
	public UserProcessor userProcessor() {
		return new UserProcessor();
	}

	@Bean
	public OrderProcessor orderProcessor() {
		return new OrderProcessor();
	}

	@Bean
	public ProductProcessor productProcessor() {
		return new ProductProcessor();
	}

	// writers
	@Bean
	public ProductWriter productWriter() {
		return new ProductWriter();
	}

	@Bean
	public OrderWriter orderWriter() {
		return new OrderWriter();
	}

	@Bean
	public UserWriter userWriter() {
		return new UserWriter();
	}
}
