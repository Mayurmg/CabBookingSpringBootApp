package com.assesment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends User {

	private Vehicle vehicle;

	private Location currentLocation;
	
	private Boolean isAvailable;
}
