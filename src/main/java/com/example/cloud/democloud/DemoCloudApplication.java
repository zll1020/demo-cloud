package com.example.cloud.democloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCloudApplication.class, args);
	}

}
