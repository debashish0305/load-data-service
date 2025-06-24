package com.debashish.load_data_service.model;

import lombok.Data;

@Data
public class User {
	private String id;
	private String name;
	private String value;
	private String address;
	private String phone;
	private String age;
	private String gender;
	private String status;
	private String registrationDate;
	private String lastLogin;
}