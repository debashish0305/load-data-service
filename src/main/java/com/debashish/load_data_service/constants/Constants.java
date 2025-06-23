package com.debashish.load_data_service.constants;


import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    public static final String[] ORDER_COLUMNS = { "id", "name", "value" };
    public static final String[] USER_COLUMNS = { "id", "name", "value" };
    public static final String[] PRODUCT_COLUMNS = { "id", "name", "value" };

    public static final String USERS_CSV_FILE = "users.csv";
    public static final String ORDERS_CSV_FILE = "orders.csv";
    public static final String PRODUCTS_CSV_FILE = "products.csv";
}
