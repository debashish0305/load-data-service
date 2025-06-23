package com.debashish.load_data_service;

import com.debashish.load_data_service.config.AppProperties;
import com.debashish.load_data_service.model.CsvInputFileType;
import com.debashish.load_data_service.service.BatchJobRunner;
import com.debashish.load_data_service.utils.CommandLineArgsUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.debashish.load_data_service.constants.Constants.*;

@Slf4j
@SpringBootApplication
@EnableBatchProcessing
@RequiredArgsConstructor
public class LoadDataServiceApplication implements CommandLineRunner {

    private final BatchJobRunner batchJobRunner;
    private final AppProperties appProperties;

    public static void main(String[] args) {
        SpringApplication.run(LoadDataServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        if (args.length < 1) {
            log.info("Please provide --job.type=USERS|ORDERS|PRODUCTS");
            return;
        }

        String jobTypeArg = CommandLineArgsUtil.getArgValue(args, "job.type"); // ex: "job.type=USERS"
        CsvInputFileType jobType = CsvInputFileType.valueOf(jobTypeArg.toUpperCase());

        String fileName = switch (jobType) {
            case USERS -> USERS_CSV_FILE;
            case ORDERS -> ORDERS_CSV_FILE;
            case PRODUCTS -> PRODUCTS_CSV_FILE;
        };


        // execute the job with the provided job type and input folder
        batchJobRunner.runJob(jobType, appProperties.getInputFolder(), fileName);
    }
}
