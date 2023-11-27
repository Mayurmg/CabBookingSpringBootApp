package com.assesment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.assesment.entity.Customer;
import com.assesment.entity.Driver;
import com.assesment.entity.Location;
import com.assesment.entity.Vehicle;
import com.assesment.enums.Gender;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CabApplicationService {

	List<Customer> users = new ArrayList<>();
	List<Driver> drivers = new ArrayList<>();

	public void addUser(String name, Gender gender, int age) {
		if (Objects.isNull(name) || Objects.isNull(gender) || Objects.isNull(age)) {
			log.error("Incomplete user details to add");
		}
		Customer user = new Customer();
		user.setName(name);
		user.setAge(age);
		user.setGender(gender);
		users.add(user);
		log.info("User added successfully: {}", user);
	}

	public void addDriver(String name, Gender gender, int age, String vehicleModel, String vehicleNumber, int latitude,
			int longitude) {
		if (Objects.isNull(name) || Objects.isNull(gender) || Objects.isNull(age) || Objects.isNull(vehicleModel)
				|| Objects.isNull(vehicleNumber) || Objects.isNull(longitude) || Objects.isNull(latitude)) {
			log.error("Incomplete driver details to add");
		}
		Driver driver = new Driver();
		driver.setName(name);
		driver.setAge(age);
		driver.setGender(gender);
		driver.setVehicle(new Vehicle(vehicleModel, vehicleNumber));
		driver.setCurrentLocation(new Location(latitude, longitude));
		driver.setIsAvailable(Boolean.TRUE);
		drivers.add(driver);
		log.info("Driver added successfully: {}", driver);
	}

	public List<Driver> findRide(String name, int sourceLatitude, int sourceLongitude, int destinationLatitude,
			int destinationLongitude) {
		// Assume a simple distance calculation for demonstration
		List<Driver> availableDrivers = drivers.stream().filter(Driver::getIsAvailable)
				.filter(driver -> calculateDistance(driver.getCurrentLocation(),
						new Location(sourceLatitude, sourceLongitude)) < 5.0)
				.collect(Collectors.toList());
		if (availableDrivers.isEmpty()) {
			log.info("No available drivers found");
		} else {
			log.info("Available drivers for user: {} are:", name);
			for (Driver driver : availableDrivers) {
				log.info(driver.getName());
			}
		}
		return availableDrivers;
	}

	private double calculateDistance(Location loc1, Location loc2) {
		// Assume a simple distance calculation for demonstration
		// In a real-world scenario, you would use a more accurate formula
		return Math.sqrt(Math.pow(loc1.getLatitude() - loc2.getLatitude(), 2)
				+ Math.pow(loc1.getLongitude() - loc2.getLongitude(), 2));
	}

	public void chooseRide(String username, String driverName) {
		// Assume a simple implementation for choosing a ride
		Driver selectedDriver = drivers.stream().filter(driver -> driver.getName().equals(driverName)).findFirst()
				.orElse(null);

		if (selectedDriver != null && selectedDriver.getIsAvailable()) {
			// Process the ride selection
			selectedDriver.setIsAvailable(false);
			log.info("{} has chosen {} for the ride.", driverName);
		} else {
			log.error("Invalid driver selection.");
		}
	}

}
