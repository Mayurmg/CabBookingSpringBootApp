package com.assesment.thinkify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.assesment.enums.Gender;
import com.assesment.service.CabApplicationService;

@SpringBootApplication
@ComponentScan(basePackages = { "com.assesment" })
public class CabBookingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CabBookingApplication.class, args);

		CabApplicationService cabBookingService = context.getBean(CabApplicationService.class);

		cabBookingService.addUser("Abhishek", Gender.MALE, 23);
		cabBookingService.addUser("Rahul", Gender.MALE, 29);
		cabBookingService.addUser("Nandini", Gender.FEMALE, 22);

		cabBookingService.addDriver("Driver1", Gender.MALE, 22, "Swift", "KA-01-12345", 10, 1);
		cabBookingService.addDriver("Driver2", Gender.MALE, 29, "Swift", "KA-01-12345", 11, 10);
		cabBookingService.addDriver("Driver3", Gender.MALE, 24, "Swift", "KA-01-12345", 5, 3);

		cabBookingService.findRide("Abhishek", 0, 0, 20, 1);
		cabBookingService.findRide("Rahul", 10, 0, 15, 3);
		cabBookingService.findRide("Nandini", 15, 6, 20, 4);
	}

}
