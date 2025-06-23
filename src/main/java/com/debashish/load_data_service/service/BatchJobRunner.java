package com.debashish.load_data_service.service;

import com.debashish.load_data_service.model.CsvInputFileType;
import com.debashish.load_data_service.model.User;
import com.debashish.load_data_service.service.processor.UserProcessor;
import com.debashish.load_data_service.service.reader.UserFileReaderFactory;
import com.debashish.load_data_service.service.writer.UserWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import static com.debashish.load_data_service.constants.Constants.USER_COLUMNS;


@RequiredArgsConstructor
@Component
public class BatchJobRunner {
    private final JobLauncher jobLauncher;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager txManager;

    public void runJob(CsvInputFileType jobType, String inputFolder, String fileName) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        Step step = new StepBuilder("step-" + jobType.name(), jobRepository)
                .<User, User>chunk(100, txManager)
                .reader(UserFileReaderFactory.create(inputFolder, fileName, USER_COLUMNS))
                .processor(new UserProcessor())
                .writer(new UserWriter())
                .build();

        Job job = new JobBuilder("job-" + jobType.name(), jobRepository)
                .start(step)
                .build();

        JobParameters params = new JobParametersBuilder()
                .addString("jobType", jobType.name())
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(job, params);
    }

}