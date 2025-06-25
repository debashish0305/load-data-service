package com.debashish.load_data_service.mapper;

import com.debashish.load_data_service.model.Product;
import com.debashish.load_data_service.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	@Mapping(source = "productId", target = "productId")
	ProductEntity toEntity(Product product);

	@Mapping(source = "productId", target = "productId")
	Product toModel(ProductEntity entity);
}