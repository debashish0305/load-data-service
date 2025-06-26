package com.debashish.load_data_service.service.processor;

import com.debashish.load_data_service.entity.UserEntity;
import com.debashish.load_data_service.mapper.UserMapper;
import com.debashish.load_data_service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProcessor implements ItemProcessor<User, UserEntity> {
	private final UserMapper userMapper;

	@Override
	public UserEntity process(User user) {
		return userMapper.toEntity(user);
	}
}