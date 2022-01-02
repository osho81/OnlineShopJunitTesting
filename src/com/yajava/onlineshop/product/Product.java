package com.yajava.onlineshop.product;

public class Product {

	// Instance variables
	private int productNumber;
	private String productName;
	private double netPrice; 
	private double vatRate;
	
	// Parametrised constructor
	public Product(int productNumber, String productName, double netPrice, double vatRate) {
		super();
		this.productNumber = productNumber;
		this.productName = productName;
		this.netPrice = netPrice;
		this.vatRate = vatRate;
	}

	// Getters and setters, since the instance variables are private
	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
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
		return "Product number: " + productNumber + "\t\tProduct name: " + productName + "\t\tNet price: " + netPrice
				+ "\t\tVAT rate: " + vatRate + "\n";
	} 
	
	
	
	
	
}
