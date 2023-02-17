package com.example.mpddemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mpddemo.mapper")
public class MpddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpddemoApplication.class, args);
	}

}
