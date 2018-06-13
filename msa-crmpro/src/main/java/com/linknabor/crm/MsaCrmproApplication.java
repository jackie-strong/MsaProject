package com.linknabor.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsaCrmproApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaCrmproApplication.class, args);
	}
}
