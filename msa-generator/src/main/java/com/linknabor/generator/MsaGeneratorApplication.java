package com.linknabor.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.linknabor.generator.mapper")
public class MsaGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaGeneratorApplication.class, args);
	}
}
