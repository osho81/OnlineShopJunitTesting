package com.yajava.onlineshop.shoppingcart;

// jsjhgdfherghioerh
// hjsdkjfgjksrgiljsdrhg

// khdrkghskjregkjhrgh

//kjndfkjgdjkrngr


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

	// Parametrised constructor 2; Could be used to re-assign an empty cart
	public ShoppingCart() {
		super();
		productList = new ArrayList<>(); // Or new ArrayList<Products>()
		// Amount variables are initialised as 0
	}

	// Getters and setters, since the instance variables are private
	public List<Product> getProductList() {
		return productList;
	}

	// This setter modifies productList
	public void setProductList(Product prod, boolean addOrRemove) {
		if (addOrRemove) {
			productList.add(prod);
		} else {
			productList.remove(prod);
		}

		// Update shoppingCart amount when adding products to it
		// Calls pertinent setters for this task
		setAmountExclVat(prod);
		setAmountInclVat(prod);
	}

	public double getAmountExclVat() {
		return amountExclVat;
	}

	public void setAmountExclVat(Product prod) {
		// Add to current amount: added product * VAT in % (i.e. /100)
		amountExclVat += (prod.getNetPrice() + (prod.getNetPrice() * (prod.getVatRate() / 100)));
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

		// Format for dots instead of comma for decimals; and only 2 decimals
		String formattedAmountExcl = String.format(Locale.US, "%.2f", amountExclVat);
		String formattedAmountIncl = String.format(Locale.US, "%.2f", amountExclVat);
		return "\n ShoppingCart:\n" + printProducts() + "\nAmount excl. VAT: " + formattedAmountExcl
				+ "\t\tAmount incl. VAT: " + formattedAmountIncl;
	}

	// Used for toString(), to write out the products in a cleaner manner
	private String printProducts() {
		String prodStr = "";
		for (Product p : productList) {
			prodStr += "Prdouct " + (productList.indexOf(p) + 1) + ": " + p;
		}
		return prodStr;
	}

}
