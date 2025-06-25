-- V2__create_user_product_order_tables.sql

CREATE SCHEMA IF NOT EXISTS load_data_service;

CREATE TABLE IF NOT EXISTS load_data_service.users (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    created_date TIMESTAMP,
    updated_date TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    version BIGINT,
    user_id VARCHAR(255),
    name VARCHAR(255),
    value VARCHAR(255),
    address VARCHAR(255),
    phone VARCHAR(255),
    age VARCHAR(255),
    gender VARCHAR(255),
    status VARCHAR(255),
    registration_date VARCHAR(255),
    last_login VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS load_data_service.products (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    created_date TIMESTAMP,
    updated_date TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    version BIGINT,
    product_id VARCHAR(255),
    name VARCHAR(255),
    value VARCHAR(255),
    category VARCHAR(255),
    brand VARCHAR(255),
    model_number VARCHAR(255),
    warranty VARCHAR(255),
    color VARCHAR(255),
    weight VARCHAR(255),
    dimensions VARCHAR(255),
    stock INTEGER,
    rating DOUBLE PRECISION,
    release_date VARCHAR(255),
    material VARCHAR(255),
    origin VARCHAR(255),
    barcode VARCHAR(255),
    energy_class VARCHAR(255),
    connectivity VARCHAR(255),
    features VARCHAR(255),
    notes VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS load_data_service.orders (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    created_date TIMESTAMP,
    updated_date TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    version BIGINT,
    order_id VARCHAR(255),
    name VARCHAR(255),
    value VARCHAR(255),
    customer VARCHAR(255),
    product VARCHAR(255),
    quantity INTEGER,
    price DOUBLE PRECISION,
    discount DOUBLE PRECISION,
    shipping_address VARCHAR(255),
    billing_address VARCHAR(255),
    order_date VARCHAR(255),
    delivery_date VARCHAR(255),
    payment_status VARCHAR(255)
);