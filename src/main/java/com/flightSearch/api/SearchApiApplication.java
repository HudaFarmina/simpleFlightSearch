package com.flightSearch.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.flightSearch"})
public class SearchApiApplication {
	
	public static void main(String[] args) 
	{	
		SpringApplication.run(SearchApiApplication.class, args);

	}

}
