package com.hashlama.hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HackathonApplication {

	public static void main(String[] args) {
		System.out.println("Started ...");
		SpringApplication.run(HackathonApplication.class, args);
	}

}
