package com.example.NetflixShow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NetflixShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixShowApplication.class, args);
	}

}
