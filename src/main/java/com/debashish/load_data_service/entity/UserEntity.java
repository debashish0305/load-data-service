package com.debashish.load_data_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users", schema = "load_data_service")
@Data
public class UserEntity extends BaseEntity {

	@Column(name = "user_id")
	private String userId;
	@Column(name = "name")
	private String name;
	@Column(name = "value")
	private String value;
	@Column(name = "address")
	private String address;
	@Column(name = "phone")
	private String phone;
	@Column(name = "age")
	private String age;
	@Column(name = "gender")
	private String gender;
	@Column(name = "status")
	private String status;
	@Column(name = "registration_date")
	private String registrationDate;
	@Column(name = "last_login")
	private String lastLogin;
}