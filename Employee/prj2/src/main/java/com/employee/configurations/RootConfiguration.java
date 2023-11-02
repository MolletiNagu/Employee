// this class is for Swagger.

// by using this URL we can access in browser: http://localhost:8080/swagger-ui/index.html

package com.employee.configurations;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class RootConfiguration {
	public class SpringFoxConfig {

		public OpenAPI springOpenAPI() {
			return new OpenAPI()
					.info(new Info().title("SERVER API DOSCUMENTATION").description("API DESCRIPTION").version("1.0"));

		}
	}

}
