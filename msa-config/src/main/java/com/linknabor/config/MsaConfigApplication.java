package com.linknabor.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class MsaConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaConfigApplication.class, args);
    }
}
