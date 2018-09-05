package com.org.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class EcomAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomAppApplication.class, args);
	}
}
