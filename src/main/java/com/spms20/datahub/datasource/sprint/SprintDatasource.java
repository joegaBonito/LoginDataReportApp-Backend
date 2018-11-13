package com.spms20.datahub.datasource.sprint;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spms20.datahub.domain.SprintLoginData;
import com.spms20.datahub.domain.SprintSitesCoordinate;
import com.spms20.datahub.domain.SprintUser;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 
 * @author Joe Jung This class allows to configure multi-datasources
 *
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "sprintEntityManagerFactory", transactionManagerRef = "sprintTransactionManager", basePackages = {
		"com.spms20.datahub.repositories.sprint" })
public class SprintDatasource {
	@Bean(name = "dataSource")
	@Primary
	@ConfigurationProperties("app.datasource.first")
	public HikariDataSource dataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Bean(name = "sprintEntityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean sprintEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") HikariDataSource dataSource) {
		return builder.dataSource(dataSource())
				.packages(SprintLoginData.class, SprintUser.class, SprintSitesCoordinate.class)
				.persistenceUnit("sprint").build();
	}

	@Bean(name = "sprintTransactionManager")
	@Primary
	public PlatformTransactionManager sprintTransactionManager(
			@Qualifier("sprintEntityManagerFactory") EntityManagerFactory sprintEntityManagerFactory) {
		return new JpaTransactionManager(sprintEntityManagerFactory);
	}
}
