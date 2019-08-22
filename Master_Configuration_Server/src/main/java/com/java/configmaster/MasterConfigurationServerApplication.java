package com.java.configmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MasterConfigurationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterConfigurationServerApplication.class, args);
	}
}
