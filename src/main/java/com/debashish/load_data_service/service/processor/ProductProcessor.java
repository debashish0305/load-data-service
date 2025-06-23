package com.debashish.load_data_service.service.processor;

import com.debashish.load_data_service.model.Product;
import org.springframework.batch.item.ItemProcessor;

public class ProductProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) {
        // Add processing logic if needed
        return item;
    }
}