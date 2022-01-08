package com.yajava.onlineshop.customer;

import java.util.Objects;

/**
 * Superclass to Customer
 */

public abstract class Person {

	// Instance variables
	private String fName;
	private String lName;
	private String address;
	private String phoneNumber;

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
	
	@Override
	public int hashCode() {
		return Objects.hash(address, fName, lName, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(fName, other.fName)
				&& Objects.equals(lName, other.lName) && Objects.equals(phoneNumber, other.phoneNumber);
	}

	// toString() method, utilised in its child-class Customer
	@Override
	public String toString() {
		return "Name: " + fName + " " + lName + "\t\tPhoneNumber: " + phoneNumber;
	}
	
	
	

}
