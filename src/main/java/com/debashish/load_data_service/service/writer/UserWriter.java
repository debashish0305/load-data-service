package com.debashish.load_data_service.service.writer;

import com.debashish.load_data_service.config.LogExecutionTime;
import com.debashish.load_data_service.entity.OrderEntity;
import com.debashish.load_data_service.entity.UserEntity;
import com.debashish.load_data_service.mapper.UserMapper;
import com.debashish.load_data_service.model.User;
import com.debashish.load_data_service.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserWriter implements ItemWriter<User> {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@LogExecutionTime
	@Override
	public void write(Chunk<? extends User> items) {
		List<UserEntity> entities = items.getItems().stream().map(userMapper::toEntity).toList();
		userRepository.saveAll(entities);
		log.info("Saved {} users", entities.size());
	}
}