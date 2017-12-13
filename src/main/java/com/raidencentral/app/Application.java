package com.raidencentral.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.raidencentral.app.wsdlartifact.GetCountryResponse;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient client) {
		return args -> {
			String countryName = "Poland";

			GetCountryResponse response = client.getCountry(countryName);
			System.out.println(": "+ response.getCountry());
			System.out.println("response.getCountry(): "+ response.getCountry().getName());
			System.out.println("response.getCountry(): "+ response.getCountry().getCapital());
			System.out.println("response.getCountry(): "+ response.getCountry().getPopulation());
			System.out.println("response.getCountry(): "+ response.getCountry().getCurrency());
		};
	}
}
