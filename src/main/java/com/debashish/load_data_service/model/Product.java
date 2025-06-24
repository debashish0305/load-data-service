package com.debashish.load_data_service.model;

import lombok.Data;

@Data
public class Product {
	private String id;
	private String name;
	private String value;
	private String category;
	private String brand;
	private String modelNumber;
	private String warranty;
	private String color;
	private String weight;
	private String dimensions;
	private Integer stock;
	private Double rating;
	private String releaseDate;
	private String material;
	private String origin;
	private String barcode;
	private String energyClass;
	private String connectivity;
	private String features;
	private String notes;
}