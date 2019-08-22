package com.java.clientservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientService1Application {

	public static void main(String[] args) {
		SpringApplication.run(ClientService1Application.class, args);
	}
	
	@Bean(value="LoadbalancedRestTemplate")
	public RestTemplate restemplate() {
		RestTemplate template = new RestTemplate();
		return template;
	}

}
