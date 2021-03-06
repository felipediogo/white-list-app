package br.com.felipediogo.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${JDBC_URL}")
    String jdbcUrl;

    @Bean
    public DataSource connect() {
        return DataSourceBuilder.create().url(jdbcUrl).build();
    }
}

