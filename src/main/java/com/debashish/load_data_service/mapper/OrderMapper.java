package com.debashish.load_data_service.mapper;

import com.debashish.load_data_service.model.Order;
import com.debashish.load_data_service.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	@Mapping(source = "orderId", target = "orderId")
	OrderEntity toEntity(Order order);

	@Mapping(source = "orderId", target = "orderId")
	Order toModel(OrderEntity entity);
}