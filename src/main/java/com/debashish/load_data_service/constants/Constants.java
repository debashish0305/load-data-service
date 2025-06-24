package com.debashish.load_data_service.constants;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class Constants {

	public static final String USERS_CSV_FILE = "users.csv";
	public static final String ORDERS_CSV_FILE = "orders.csv";
	public static final String PRODUCTS_CSV_FILE = "products.csv";

	public static final String BEAN_USER_STEP = "userStep";
	public static final String BEAN_ORDER_STEP = "orderStep";
	public static final String BEAN_PRODUCT_STEP = "productStep";

	public static final List<String> USER_COLUMNS = List.of("id", "name", "value", "address", "phone", "age", "gender",
			"status", "registrationDate", "lastLogin");
	public static final List<String> ORDER_COLUMNS = List.of("id", "name", "value", "customer", "product", "quantity",
			"price", "discount", "shippingAddress", "billingAddress", "orderDate", "deliveryDate", "paymentStatus");

	public static final List<String> PRODUCT_COLUMNS = List.of("id", "name", "value", "category", "brand",
			"modelNumber", "warranty", "color", "weight", "dimensions", "stock", "rating", "releaseDate", "material",
			"origin", "barcode", "energyClass", "connectivity", "features", "notes");
}
