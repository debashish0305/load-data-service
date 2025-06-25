// src/main/java/com/debashish/load_data_service/aop/ExecutionTimeAspect.java
package com.debashish.load_data_service.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ExecutionTimeAspect {

	@Around("@annotation(com.debashish.load_data_service.config.LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long end = System.currentTimeMillis();
		log.info("{} method took {} ms for execution", joinPoint.getSignature(), (end - start));
		return proceed;
	}
}