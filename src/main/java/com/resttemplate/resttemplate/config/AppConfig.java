package com.resttemplate.resttemplate.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.Bean;

@Configuration
@ComponentScan("com.resttemplate.resttemplate")
public class AppConfig {
	
	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter converter= new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(new ObjectMapper());
		restTemplate.getMessageConverters().add(converter);
		return restTemplate;
	}

}
