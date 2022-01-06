package com.yajava.onlineshop.person;

/**
 * Superclass to Customer
 */

public abstract class Person {

	// Instance variables
	private String fName;
	private String lName;
	private String address;
	private String phoneNumber;
	// emailAddress?

	// Parametrised constructor - used by inheriting child-class
	public Person(String fName, String lName, String address, String phoneNumber) {
		super();
		this.fName = fName; // this keyword needed because parameters has same name as variable
		this.lName = lName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	// Getters and setters, since the instance variables are private
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// toString() method, utilised in its child-class Customer
	@Override
	public String toString() {
		return "Name: " + fName + " " + lName + "\t\tPhoneNumber: " + phoneNumber;
	}
	
	
	

}
