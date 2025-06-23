package com.debashish.load_data_service.service.reader;

import com.debashish.load_data_service.model.User;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.core.io.FileSystemResource;

public class UserFileReaderFactory {
    public static FlatFileItemReader<User> create(String path, String fileName, String[] columns) {
        return new FlatFileItemReaderBuilder<User>()
                .name("csvReader-" + fileName)
                .resource(new FileSystemResource(path + fileName))
                .delimited()
                .names(columns)
                .targetType(User.class)
                .linesToSkip(1)
                .build();
    }
}