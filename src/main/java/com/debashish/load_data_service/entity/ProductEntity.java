package com.debashish.load_data_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "products", schema = "load_data_service")
@Data
public class ProductEntity extends BaseEntity {

	@Column(name = "product_id")
	private String productId;
	@Column(name = "name")
	private String name;
	@Column(name = "value")
	private String value;
	@Column(name = "category")
	private String category;
	@Column(name = "brand")
	private String brand;
	@Column(name = "model_number")
	private String modelNumber;
	@Column(name = "warranty")
	private String warranty;
	@Column(name = "color")
	private String color;
	@Column(name = "weight")
	private String weight;
	@Column(name = "dimensions")
	private String dimensions;
	@Column(name = "stock")
	private Integer stock;
	@Column(name = "rating")
	private Double rating;
	@Column(name = "release_date")
	private String releaseDate;
	@Column(name = "material")
	private String material;
	@Column(name = "origin")
	private String origin;
	@Column(name = "barcode")
	private String barcode;
	@Column(name = "energy_class")
	private String energyClass;
	@Column(name = "connectivity")
	private String connectivity;
	@Column(name = "features")
	private String features;
	@Column(name = "notes")
	private String notes;
}