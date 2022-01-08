package com.yajava.onlineshop.shoppingcart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import com.yajava.onlineshop.product.CompareProductPrice;
import com.yajava.onlineshop.product.CompareProductVat;
import com.yajava.onlineshop.product.Product;

public class ShoppingCart {

	// Instance variables
	private List<Product> shopList;
	private double amountExclVat;
	private double amountInclVat;

	// Parametrised constructor (WILL PROBABLY DELETE THIS)
//	public ShoppingCart(List<Product> productList) {
//		super();
//		this.productList = productList;
//	}

	// Parametrised constructor; create shopping cart and assing it a list
	public ShoppingCart() {
		super();
		shopList = new ArrayList<>(); // Or new ArrayList<Products>()
		// Amount variables are initialised as 0
	}

	// Getters and setters, since the instance variables are private
	public List<Product> getShopList() {
		return shopList;
	}

	// This setter modifies productList; if true add prod, else remove
	public void setShopList(Product prod) {
		shopList.add(prod);

		// Update/increase shoppingCart cost accordingly
		setAmountExclVat(prod);
		setAmountInclVat(prod);
	}

	public double getAmountExclVat() {
		return amountExclVat;
	}

	public void setAmountExclVat(Product prod) {
		// Add to current amount: added product's net price
		amountExclVat += prod.getNetPrice();
	}

	public double getAmountInclVat() {
		return amountInclVat;
	}

	public void setAmountInclVat(Product prod) {
		// Add to current amount: added product * VAT in % (i.e. /100)
		amountInclVat += (prod.getNetPrice() + (prod.getNetPrice() * (prod.getVatRate() / 100)));
	}

	// Method for removing returned item; called by returnItem() in Customer
	public void removeItem(Product prod) {
		shopList.remove(prod);

		// Update/decrease shoppingCart cost accordingly
		amountExclVat -= prod.getNetPrice();
		amountInclVat -= (prod.getNetPrice() + (prod.getNetPrice() * (prod.getVatRate() / 100)));
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountExclVat, amountInclVat, shopList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		return Double.doubleToLongBits(amountExclVat) == Double.doubleToLongBits(other.amountExclVat)
				&& Double.doubleToLongBits(amountInclVat) == Double.doubleToLongBits(other.amountInclVat)
				&& Objects.equals(shopList, other.shopList);
	}

	// toString(), utilised in customer
	@Override
	public String toString() {

		// Format for dots instead of comma for decimals; and only 2 decimals
		String formattedAmountExcl = String.format(Locale.US, "%.2f", amountExclVat);
		String formattedAmountIncl = String.format(Locale.US, "%.2f", amountInclVat);
		return "\n\nShoppingCart:\n" + printProducts() + "\nAmount excl. VAT: " + formattedAmountExcl
				+ "\t\tAmount incl. VAT: " + formattedAmountIncl;
	}

	// Complements toString() standard method, to print products in a clear manner
	private String printProducts() {
		String prodStr = "";
		int prodCount = 1;
		for (Product p : shopList) {
			prodStr += "Product " + (prodCount++) + ": " + p + "\n";
		}
		return prodStr;
	}

	// Calls Comparable's standard method compareTo, to sort by product name
	public void shopListByName() {
		Collections.sort(getShopList());
	}

	// Calls external comparators for product (list) sorting by price
	public void shopListByPrice() {
		CompareProductPrice listByPrice = new CompareProductPrice();
		Collections.sort(shopList, listByPrice);
	}

	// Calls external comparators for product (list) sorting by VAT
	public void shopListByVat() {
		CompareProductVat listByVat = new CompareProductVat();
		Collections.sort(shopList, listByVat);
	}

}
