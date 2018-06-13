package com.linknabor.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@EnableEurekaClient
//@EnableScheduling
@MapperScan("com.linknabor.job.mapper")
//@EnableTransactionManagement //开启事务管理
public class MsaTimerjobApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaTimerjobApplication.class, args);
	}
}
