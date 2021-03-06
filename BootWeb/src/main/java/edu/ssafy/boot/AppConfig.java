package edu.ssafy.boot;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AppConfig {
	@Bean
	//transaction 가능하게 하는 어노테이션
	public PlatformTransactionManager getPlatformTransactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
}
