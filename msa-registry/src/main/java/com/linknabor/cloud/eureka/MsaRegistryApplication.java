package com.linknabor.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsaRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaRegistryApplication.class, args);
    }
}
