package edu.ssafy.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootWebApplication.class, args);
		//아래와 같은 코드가 위 함수에 내장되어 잇어서 시작하자마자 appliation.properties를 읽는거야!
		//new SpringApplicationBuilder(BootWebApplication.class).properties("spring.config.location=classpath:/application.properties,classpath:/application.yml").run(args);
	}

}
