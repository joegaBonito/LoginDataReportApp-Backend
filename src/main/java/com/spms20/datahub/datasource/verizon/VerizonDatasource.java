package com.spms20.datahub.datasource.verizon;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spms20.datahub.domain.VerizonLoginData;
import com.spms20.datahub.domain.VerizonSitesCoordinate;
import com.spms20.datahub.domain.VerizonUser;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 
 * @author Joe Jung
 * This class allows to configure multi-datasources
 *
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "verizonEntityManagerFactory",
		  transactionManagerRef ="verizonTransactionManager",
  basePackages = { "com.spms20.datahub.repositories.verizon" }
)
public class VerizonDatasource {
	@Bean(name = "dataSource2")
	@ConfigurationProperties("app.datasource.second")
	public HikariDataSource dataSource2(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
	

	 @Bean(name = "verizonEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean verizonEntityManagerFactory(
			EntityManagerFactoryBuilder builder, @Qualifier("dataSource2") HikariDataSource dataSource) {
		return builder
				.dataSource(dataSource2())
				.packages(VerizonLoginData.class,VerizonUser.class, VerizonSitesCoordinate.class)
				.persistenceUnit("verizon")
				.build();
	}
	 
	 @Bean(name = "verizonTransactionManager")
	  public PlatformTransactionManager verizonTransactionManager(
	    @Qualifier("verizonEntityManagerFactory") EntityManagerFactory
	    verizonEntityManagerFactory
	  ) {
	    return new JpaTransactionManager(verizonEntityManagerFactory);
	  }
}
