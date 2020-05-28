package com.cuisf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.cuisf.*.mapper"})
public class Erp2Application {

	public static void main(String[] args) {
		SpringApplication.run(Erp2Application.class, args);
	}

}
