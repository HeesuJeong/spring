package edu.ssafy.boot;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({"edu.ssafy"}) //스캔하고 싶은 경로 지정
//@EnableWebMvc  //mvcContainer에도 들어가 대신 extends해줘야해
//@EnableTransactionManagement
//자바 8.0 이상에서 오라클로 넘어가면서 interface인데 앞에 default붙이면 구현부 붙여서 미구현메소드 그대로 둘 수 있다
public class WebConfig implements WebMvcConfigurer {
	
	/* config 설정하는 방법
	 * @Bean public DataSource getDataSource() { BasicDataSource ds = new
	 * BasicDataSource(); ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	 * ds.setUrl(
	 * "jdbc:mysql://localhost:3306/springweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8"
	 * ); ds.setUsername("ssafy"); ds.setPassword("ssafy"); ds.setMaxActive(20);
	 * return ds; }
	 * 
	 * @Bean public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource ds) {
	 * SqlSessionFactoryBean sbean = new SqlSessionFactoryBean();
	 * sbean.setDataSource(ds); String
	 * configLoc="classpath:/spring/MybatisConfig.xml"; sbean.setConfigLocation(new
	 * PathMatchingResourcePatternResolver().getResource(configLoc)); return sbean;
	 * }
	 * 
	 * @Bean public ViewResolver getViewResolver() { InternalResourceViewResolver
	 * resolver = new InternalResourceViewResolver();
	 * resolver.setPrefix("/WEB-INF/"); resolver.setSuffix(".jsp"); return resolver;
	 * }
	 */
	
}
