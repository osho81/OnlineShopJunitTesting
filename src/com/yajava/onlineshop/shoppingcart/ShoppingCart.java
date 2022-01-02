package com.yajava.onlineshop.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import com.yajava.onlineshop.product.Product;

public class ShoppingCart {

	// Instance variables
	private List<Product> productList;
	private double amountExclVat;
	private double amountInclVat;

	// Parametrised constructor 1 (WILL PROBABLY DELETE THIS)
	public ShoppingCart(List<Product> productList, double amountExclVat, double amountInclVat) {
		super();
		this.productList = productList;
		this.amountExclVat = amountExclVat;
		this.amountInclVat = amountInclVat;
	}

	// Parametrised constructor 2
	public ShoppingCart() {
		super();
		productList = new ArrayList<Product>();
		// Amounts are initialised as 0
	}

	// Getters and setters, since the instance variables are private
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(Product prod) {
		productList.add(prod); // This setter modifies productList
		// Update shoppingCart amount when adding products to it
		setAmountExclVat(prod);
		setAmountInclVat(prod);
	}

	public double getAmountExclVat() {
		return amountExclVat;
	}

	public void setAmountExclVat(Product prod) {
		// Add to current amount: added product * VAT in % (i.e. /100)
		amountExclVat += (prod.getNetPrice() + (prod.getNetPrice() * (prod.getVatRate()/100)));
	}

	public double getAmountInclVat() {
		return amountInclVat;
	}

	public void setAmountInclVat(Product prod) {
		// Add to current amount: added product's net price
		amountInclVat += prod.getNetPrice();
	}

	// toString(), utilised in customer
	@Override
	public String toString() {
		return "\nShoppingCart:\n" + printProducts() + "\nAmount excl. VAT: " + amountExclVat + "\t\tAmount incl. VAT: "
				+ amountInclVat;
	}

	// Used in this toString() since it otherwise prints out list in a default manner
	private String printProducts() {
		String prodStr = "";
		for (Product p : productList) {
			prodStr += "" + p; // Concatenating shortcut
		}
		return prodStr;
	}

}
