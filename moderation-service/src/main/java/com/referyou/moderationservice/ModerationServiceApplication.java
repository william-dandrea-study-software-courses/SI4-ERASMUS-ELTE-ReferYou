package com.referyou.moderationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ModerationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModerationServiceApplication.class, args);
	}

}
