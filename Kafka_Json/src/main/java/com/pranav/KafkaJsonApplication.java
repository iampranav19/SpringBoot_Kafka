package com.pranav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaJsonApplication.class, args);
		System.out.println("++++++++ Application Up and Running ++++++++++++");
	}

}
