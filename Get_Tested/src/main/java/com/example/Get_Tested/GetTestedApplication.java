package com.example.Get_Tested;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {PropertyPlaceholderAutoConfiguration.class})
public class GetTestedApplication {
	public static void main(String[] args) {
		SpringApplication.run(GetTestedApplication.class, args);
	}

}
