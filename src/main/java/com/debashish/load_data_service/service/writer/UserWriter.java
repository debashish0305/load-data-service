package com.debashish.load_data_service.service.writer;

import com.debashish.load_data_service.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

@Slf4j
public class UserWriter implements ItemWriter<User> {
	@Override
	public void write(Chunk<? extends User> items) {
		for (User item : items) {
			log.info("Writing item: {}", item);
		}
	}
}