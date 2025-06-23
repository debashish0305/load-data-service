package com.debashish.load_data_service;

import com.debashish.load_data_service.utils.CommandLineArgsUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.util.Map;

import static com.debashish.load_data_service.utils.CommandLineArgsUtil.getStepBeanName;

@Slf4j
@SpringBootApplication
@EnableBatchProcessing
@RequiredArgsConstructor
public class LoadDataServiceApplication implements CommandLineRunner {

	private final JobLauncher jobLauncher;
	private final JobRepository jobRepository;
	private final Map<String, Step> stepBeans; // Injects all steps by bean name

	public static void main(String[] args) {
		SpringApplication.run(LoadDataServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		if (args == null || args.length == 0) {
			log.error("Missing required argument: --job.type=USERS|ORDERS|PRODUCTS");
			return;
		}

		String jobType = CommandLineArgsUtil.getArgValue(args, "job.type");
		if (!StringUtils.hasText(jobType)) {
			log.error("Invalid or missing job.type argument.");
			return;
		}

		String stepBeanName = getStepBeanName(jobType);
		Step step = stepBeans.get(stepBeanName);
		if (step == null) {
			log.error("No step bean found for job type: {}", jobType);
			return;
		}

		Job job = new JobBuilder("job-" + jobType, jobRepository).start(step).build();

		JobParameters jobParameters = new JobParametersBuilder().addString("jobType", jobType)
				.addLong("runTime", System.currentTimeMillis()).toJobParameters();

		try {
			log.info("Starting job: {} with parameters: {}", job.getName(), jobParameters);
			JobExecution execution = jobLauncher.run(job, jobParameters);
			log.info("Job {} finished with status: {}", job.getName(), execution.getStatus());
		} catch (Exception e) {
			log.error("Job execution failed for job type: {}", jobType, e);
		}
	}

}
