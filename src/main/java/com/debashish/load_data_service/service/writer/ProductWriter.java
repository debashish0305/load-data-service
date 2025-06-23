package com.debashish.load_data_service.service.writer;

import com.debashish.load_data_service.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

@Slf4j
public class ProductWriter implements ItemWriter<Product> {
    @Override
    public void write(Chunk<? extends Product> items) {
        for (Product item : items) {
            log.info("Writing item: {}", item);
        }
    }
}