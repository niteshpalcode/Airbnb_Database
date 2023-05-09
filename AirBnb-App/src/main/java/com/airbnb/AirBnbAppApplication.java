package com.airbnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirBnbAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirBnbAppApplication.class, args);
		System.out.println("Running");
	}

}
