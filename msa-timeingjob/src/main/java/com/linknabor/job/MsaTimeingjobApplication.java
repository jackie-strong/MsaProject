package com.linknabor.job;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.linknabor.job.mapper")
@EnableTransactionManagement //开启事务管理
public class MsaTimeingjobApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaTimeingjobApplication.class, args);
	}
}
