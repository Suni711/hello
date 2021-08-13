package com.captal.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import nz.net.ultraq.thymeleaf.LayoutDialect;

@SpringBootApplication
@EnableAutoConfiguration
public class CapitalAccountSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapitalAccountSystemApplication.class, args);

	

	}
		@Bean 
		LayoutDialect thymeleafDialect()
		{
			
			return new LayoutDialect();
		}
		
		
	
	}