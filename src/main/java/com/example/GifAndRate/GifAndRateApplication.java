package com.example.GifAndRate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GifAndRateApplication {

	public static void main(String[] args) {
		SpringApplication.run(GifAndRateApplication.class, args);
	}

}
