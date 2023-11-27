package com.assesment.entity;

import com.assesment.enums.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private String name;

	private Gender gender;

	private int age;

}
