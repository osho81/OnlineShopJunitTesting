package com.yajava.onlineshop.main;

import com.yajava.onlineshop.person.customer.Customer;
import com.yajava.onlineshop.product.Product;
import com.yajava.onlineshop.shoppingcart.ShoppingCart;

public class TemporaryMain {

	public static void main(String[] args) {

		// Creating and initializating products 
		Product shoes = new Product("035", "Shoes", 700, 10);
		Product pants = new Product("045", "Pants", 400, 15);
		Product candy = new Product("055", "Candy", 50, 25);
		
		// Creating and initializating shopping carts
		ShoppingCart shopCart7 = new ShoppingCart();
		ShoppingCart shopCart12 = new ShoppingCart();
		
		// Filling shopping cart before it is assigned to a customer
		shopCart7.setProductList(shoes);
		shopCart7.setProductList(pants);
		shopCart7.setProductList(candy);
		shopCart7.setProductList(candy);

		// Creating and initializating a customer, of whom one is assigned a shopping cart later
		Customer customer7 = new Customer("Donald", "Duck", "Oslo", "070-7070707", 7, shopCart7);
		Customer customer12 = new Customer("Mickey", "Mouse", "Stockholm", "070-6060606", 12, null);
		
		// Assign a shopping cart to a customer
		customer12.setShopCart(shopCart12);
		
		// Filling a shopping cart after it is assigned to a customer
		customer12.getShopCart().setProductList(candy);
		customer12.getShopCart().setProductList(pants);
		
		// With "hidden logic"; set product to shopCart via customer-method
		customer7.addToCart(pants);
		
		
		
		
		
		
		
		System.out.println(customer7 + "\n" + customer12);
		

	}

}
