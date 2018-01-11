package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.vaadin.spring.events.annotation.EnableEventBus;

@SpringBootApplication
@EnableEventBus
public class EventbusDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventbusDemoApplication.class, args);
	}
}
