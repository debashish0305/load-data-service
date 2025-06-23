package com.debashish.load_data_service.service.processor;

import com.debashish.load_data_service.model.User;
import org.springframework.batch.item.ItemProcessor;

public class UserProcessor implements ItemProcessor<User, User> {
	@Override
	public User process(User user) {
		return user;
	}
}