package com.revature.hotelmagicbooknolombok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EntityScan(basePackages = {"com.revature.hotelmagicbooknolombok.model"})
public class HotelmagicbooknolombokApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelmagicbooknolombokApplication.class, args);
	}

}
