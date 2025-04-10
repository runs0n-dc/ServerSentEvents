package com.example.Assignment.Pothis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PothisApplication {

	public static void main(String[] args) {

		SpringApplication.run(PothisApplication.class, args);
		System.out.println("Pothi-Assignment");
	}
}
