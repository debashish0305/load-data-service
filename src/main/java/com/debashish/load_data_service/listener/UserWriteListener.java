package com.debashish.load_data_service.listener;

import com.debashish.load_data_service.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.item.Chunk;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserWriteListener implements ItemWriteListener<UserEntity> {

	@Override
	public void beforeWrite(Chunk<? extends UserEntity> items) {
		log.info("About to write: {}", items.getItems());
	}

	@Override
	public void afterWrite(Chunk<? extends UserEntity> items) {
		log.info("Successfully wrote: {}", items.getItems());
	}

	@Override
	public void onWriteError(Exception exception, Chunk<? extends UserEntity> items) {
		log.error("Error writing: {}, Error: {}", items.getItems(), exception.getMessage());
	}
}
