package com.debashish.load_data_service.mapper;

import com.debashish.load_data_service.model.User;
import com.debashish.load_data_service.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
	@Mapping(source = "userId", target = "userId")
	UserEntity toEntity(User user);

	@Mapping(source = "userId", target = "userId")
	User toModel(UserEntity entity);
}