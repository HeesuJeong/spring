package edu.ssafy.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/**")) // rest* : api/rest에 시작하는 모든 것을 문서로 만든다는 소리임. 즉 실행하면 알아서 문서가 만들어져있음
                                                    // rest** : 패턴이 일치하지 않아서 delete 안 뜨므로 , 그 하위까지 사용할 수 있도록 정규표현방식을 수정한다.
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("SSAFY API").description("SSAFY API Reference for Developers")
                .termsOfServiceUrl("https://edu.ssafy.com").contact("ssafy@ssafy.com").license("SSAFY License")
                .licenseUrl("ssafy@ssafy.com").version("1.0").build();
    }
}
