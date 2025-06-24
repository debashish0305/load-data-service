package com.debashish.load_data_service.utils;

import lombok.experimental.UtilityClass;

import static com.debashish.load_data_service.constants.Constants.*;

@UtilityClass
public class CommandLineArgsUtil {

	public static String getArgValue(String[] args, String key) {
		String prefix = key + "=";
		for (String arg : args) {
			if (arg.startsWith(prefix)) {
				return arg.substring(prefix.length());
			}
		}
		throw new IllegalArgumentException("Missing required argument: " + prefix + "<value>");
	}

	/*
	 * Bean names for different job types
	 */
	public static String getStepBeanName(String jobTypeArg) {
		return switch (jobTypeArg.toUpperCase()) {
			case "USERS" -> BEAN_USER_STEP;
			case "ORDERS" -> BEAN_ORDER_STEP;
			case "PRODUCTS" -> BEAN_PRODUCT_STEP;
			default -> throw new IllegalArgumentException("Invalid job.type: " + jobTypeArg);
		};

	}
}