package com.spms20.datahub;

import javax.sql.DataSource;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication(scanBasePackages = {"com.spms20.datahub"})
public class DatahubApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(DatahubApplication.class, args);
	}
	

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/getLoginDataOutputList").allowedOrigins("http://localhost:8000");
				registry.addMapping("/api/sprint/sites_coordinate_info").allowedOrigins("http://localhost:3000");
				registry.addMapping("/api/verizon/sites_coordinate_info").allowedOrigins("http://localhost:3000");
			}
			
}
