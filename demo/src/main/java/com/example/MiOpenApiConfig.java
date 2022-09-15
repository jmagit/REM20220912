package com.example;

import java.util.TreeMap;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class MiOpenApiConfig {
	@Bean
	public OpenApiCustomiser sortSchemasAlphabetically() {
	    return openApi -> {
	        var schemas = openApi.getComponents().getSchemas();
	        openApi.getComponents().setSchemas(new TreeMap<>(schemas));
	    };
	}

}
