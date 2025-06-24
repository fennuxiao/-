package com.example.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.health.dao")
public class HealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthApplication.class, args);
	}

}
