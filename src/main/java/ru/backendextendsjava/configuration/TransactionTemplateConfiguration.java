package ru.backendextendsjava.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
public class TransactionTemplateConfiguration {
    private final DataSource dataSource;

    public TransactionTemplateConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public TransactionTemplate buildTransactionTemplate() {
        return new TransactionTemplate(buildTransactionManager());
    }

    private DataSourceTransactionManager buildTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
