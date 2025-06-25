// src/main/java/com/debashish/load_data_service/aop/LogExecutionTime.java
package com.debashish.load_data_service.config;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {
}