package com.yajava.onlineshop.customer;

/**
 * Customer class Inherits from Person.
 * The class acts as blueprint for creating customer objects.
 */

import java.util.Objects;

import com.yajava.onlineshop.product.Product;
import com.yajava.onlineshop.shoppingcart.ShoppingCart;

public class Customer extends Person {

	// Instance variables
	private int customerID;
	private ShoppingCart shopCart;

	// Parametrised constructor - to create customer-objects from
	public Customer(String fName, String lName, String address, String phoneNumber, int customerID,
			ShoppingCart shopCart) {
		super(fName, lName, address, phoneNumber); // Applies superclass' constructor for these parameters
		this.customerID = customerID;
		this.shopCart = shopCart;
	}

	// Getters and setters, since the instance variables are private
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public ShoppingCart getShopCart() {
		return shopCart;
	}

	// Could be used to renew or assign another shopping cart for some reason
	public void setShopCart(ShoppingCart shopCart) {
		this.shopCart = shopCart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(customerID, shopCart);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return customerID == other.customerID && Objects.equals(shopCart, other.shopCart);
	}

	// toString() for Customer, that also uses Person's & ShoppingCart's toStrings
	@Override
	public String toString() {
		return "Customer number: " + customerID + "\t\t" + super.toString() + shopCart + "\n";
	}

	// Method for buying an item
	public void buyItem(Product prod) {
		shopCart.addToShopList(prod); 
	}

	// Method for returning item; only possible if already in shopping cart
	public void returnItem(Product prod) {
		if (shopCart.getShopList().contains(prod)) {
			shopCart.removeFromShopList(prod);
		} else {
			System.out.println("Can't remove product. No such product in your cart.");
		}
	}
}
