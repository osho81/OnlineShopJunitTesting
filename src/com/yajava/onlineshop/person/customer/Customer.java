package com.yajava.onlineshop.person.customer;

import com.yajava.onlineshop.person.Person;
import com.yajava.onlineshop.product.Product;
import com.yajava.onlineshop.shoppingcart.ShoppingCart;

public class Customer extends Person {
	
	// Instance variables
	private int customerNumber;
	private ShoppingCart shopCart;
	
	// Parametrised constructor - to create customers from
	public Customer(String fName, String lName, String address, String phoneNumber, int customerNumber, ShoppingCart shopCart) {
		super(fName, lName, address, phoneNumber); // Applies superclass' constructor for these parameters
		this.customerNumber = customerNumber;
		this.shopCart = shopCart;
	}
	
	// Getters and setters, since the instance variables are private
	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public ShoppingCart getShopCart() {
		return shopCart;
	}
	public void setShopCart(ShoppingCart shopCart) {
		this.shopCart = shopCart;
	}

	// toString() for Customer, that calls toString in ShoppingCart and Person
	@Override
	public String toString() {
		return "Customer number: " + customerNumber + "\t\t" + super.toString() + shopCart + "\n";
	}

	
	// Non-standard instance method that uses shopCart setter
	public void addToCart(Product prod) {
		getShopCart().setProductList(prod);
	}

	
	
	
	
}
