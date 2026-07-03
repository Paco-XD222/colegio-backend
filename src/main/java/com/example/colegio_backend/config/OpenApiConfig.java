package com.example.colegio_backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI colegioOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("Examen Final de Tecnologias Emergentes SIS-414")
						.description("""
								Sistema web administrable para el Colegio Carlos Medinaceli.
								Estudiante: Cristian David Paco Bravo
								RU: 107514
								CI: 10468787
								""")
						.version("1.0"));
	}
}
