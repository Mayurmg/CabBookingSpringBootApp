//package com.assesment.runner;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.assesment.enums.Gender;
//import com.assesment.service.CabApplicationService;
//
//@Component
//public class TestRunner implements CommandLineRunner {
//
//	@Autowired
//	private CabApplicationService cabBookingService;
//
//	@Override
//	public void run(String... args) throws Exception {
//		// Execute the sample test cases
//		cabBookingService.addUser("Abhishek", Gender.MALE, 23);
//		cabBookingService.addUser("Rahul", Gender.MALE, 29);
//		cabBookingService.addUser("Nandini", Gender.FEMALE, 22);
//
//		cabBookingService.addDriver("Driver1", Gender.MALE, 22, "Swift", "KA-01-12345", 10, 1);
//		cabBookingService.addDriver("Driver2", Gender.MALE, 29, "Swift", "KA-01-12345", 11, 10);
//		cabBookingService.addDriver("Driver3", Gender.MALE, 24, "Swift", "KA-01-12345", 5, 3);
//
//		cabBookingService.findRide("Abhishek", 0, 0, 20, 1);
//		cabBookingService.findRide("Rahul", 10, 0, 15, 3);
//		cabBookingService.findRide("Nandini", 15, 6, 20, 4);
//	}
//}