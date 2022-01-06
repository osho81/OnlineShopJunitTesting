package com.yajava.onlineshop.product;

import java.util.Locale;

public class Product {

	// Instance variables
	private String productNumber;
	private String productName;
	private double netPrice;
	private double vatRate;

	// Parametrised constructor - to create products from
	public Product(String productNumber, String productName, double netPrice, double vatRate) {
		super();
		this.productNumber = productNumber;
		this.productName = productName;
		this.netPrice = netPrice;
		this.vatRate = vatRate;
	}

	// Getters and setters, since the instance variables are private
	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
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
	public String toString() {
		String formattedVatRate = String.format(Locale.US, "%.2f", vatRate);
		String formattedNetPrice = String.format(Locale.US, "%.2f", vatRate);
		return String.format("%-25s%-25s%-20s%-15s", "Product number: " + productNumber, "Product name: " + productName,
				"Net price: " + formattedNetPrice, "VAT rate: " + formattedVatRate + "%\n");
	}

}
