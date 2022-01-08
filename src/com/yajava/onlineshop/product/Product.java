package com.yajava.onlineshop.product;

import java.text.Collator;
import java.util.Locale;
import java.util.Objects;

public class Product implements Comparable<Product> {

	// Instance variables
	private int productID;
	private String productName;
	private double netPrice;
	private double vatRate;

	// Parametrised constructor - to create products from
	public Product(int productID, String productName, double netPrice, double vatRate) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.netPrice = netPrice;
		this.vatRate = vatRate;
	}

	// Getters and setters, since the instance variables are private
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	public double getVatRate() {
		return vatRate;
	}

	public void setVatRate(double vatRate) {
		this.vatRate = vatRate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(netPrice, productID, productName, vatRate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Double.doubleToLongBits(netPrice) == Double.doubleToLongBits(other.netPrice)
				&& Objects.equals(productID, other.productID) && Objects.equals(productName, other.productName)
				&& Double.doubleToLongBits(vatRate) == Double.doubleToLongBits(other.vatRate);
	}

	@Override
	public String toString() {
		String formattedVatRate = String.format(Locale.US, "%.2f", vatRate);
		String formattedNetPrice = String.format(Locale.US, "%.2f", netPrice);
		return String.format("%-25s%-25s%-20s%-15s", "Product ID: " + productID, "Product name: " + productName,
				"Net price: " + formattedNetPrice, "VAT rate: " + formattedVatRate + "%");
	}

	// compareTo() standard method; compares product name order alphabetically
	public int compareTo(Product otherProd) {
		
		// Chosen Locale is added to enable Swedish vowels
		Collator col = Collator.getInstance(new Locale("sv","SE"));
		col.setStrength(Collator.PRIMARY);

		// Compare current products's name with passed in product's name
		return col.compare(productName, otherProd.productName); // returns -1, 1, 0
	}
}
