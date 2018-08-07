package com.neusoft.ngcp.projectlet.backend.mgwcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MgwCoreFeignConfiguration {

	@Bean
	public MgwCoreRequestInterceptor correlationRequestInterceptor() {
		return new MgwCoreRequestInterceptor();
	}

}
