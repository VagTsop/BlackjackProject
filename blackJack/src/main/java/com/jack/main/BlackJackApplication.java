package com.jack.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BlackJackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackJackApplication.class, args);
	}

}
