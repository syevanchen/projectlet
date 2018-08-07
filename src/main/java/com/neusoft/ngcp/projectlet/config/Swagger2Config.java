package com.neusoft.ngcp.projectlet.config;

import static com.google.common.collect.Sets.newHashSet;
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.produces(newHashSet("application/json"))
				.select()
				.paths(paths())
				.build()
				.apiInfo(apiInfo());
	}


	private Predicate<String> paths() {
		return regex("/api.*");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Ngdata BDAS API")
				.description("业务数据服务")
				.build();
	}

}
