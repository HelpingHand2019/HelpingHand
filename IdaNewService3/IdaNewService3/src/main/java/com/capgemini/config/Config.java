package com.capgemini.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {
	 @Bean
	    @Primary
	    @ConfigurationProperties(prefix = "spring.datasource")
	    public DataSource dataSource() {
	        DataSourceBuilder dsb = DataSourceBuilder.create();
	        if (dsb == null) {
	            return null;
	        }
	        return dsb.build();
	    }

}
