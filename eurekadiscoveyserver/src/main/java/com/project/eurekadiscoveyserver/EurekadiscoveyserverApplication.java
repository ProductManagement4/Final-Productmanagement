package com.project.eurekadiscoveyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekadiscoveyserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekadiscoveyserverApplication.class, args);
	}

}
