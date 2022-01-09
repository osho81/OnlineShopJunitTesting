package com.yajava.onlineshop.main;

import java.util.Collections;

import com.yajava.onlineshop.customer.Customer;
import com.yajava.onlineshop.customer.Person;
import com.yajava.onlineshop.product.Product;
import com.yajava.onlineshop.shoppingcart.ShoppingCart;

public class TemporaryMain {

	public static void main(String[] args) {

		// Creating and initializating products
		Product shoes = new Product(035, "Shoes", 500, 10);
		Product pants = new Product(045, "Pants", 300, 15);
		Product candy = new Product(055, "Candy", 100, 25);
		Product apple = new Product(065, "Äpple", 100, 25);
		Product herbtea = new Product(075, "Örtte", 50, 25);
		Product eel = new Product(075, "Ål", 200, 20);

		// Creating and initializating shopping carts
		ShoppingCart shopCart1 = new ShoppingCart();
		ShoppingCart shopCart2 = new ShoppingCart();

		// Filling shopping cart before it is assigned to a customer
		shopCart1.addToShopList(shoes);
		shopCart1.addToShopList(pants);
		shopCart1.addToShopList(candy);

		// Creating and initializating a customer, of whom one is assigned a shopping
		// cart later
		Customer customer1 = new Customer("Donald", "Duck", "Oslo", "070-7070707", 7, shopCart1);
		Customer customer2 = new Customer("Mickey", "Mouse", "Stockholm", "070-6060606", 12, null);

		// Assign a shopping cart to a customer
		customer2.setShopCart(shopCart2);

		// Filling a shopping cart after it is assigned to a customer
		customer2.buyItem(candy); // Hidden logic
		customer2.buyItem(pants);
		customer2.buyItem(shoes);
		customer2.buyItem(apple); // Hidden logic
		customer2.buyItem(pants);
		customer2.buyItem(shoes);
		customer2.returnItem(shoes);
		customer2.buyItem(shoes);
		customer2.returnItem(shoes);
		customer2.returnItem(shoes);
		customer2.returnItem(shoes);
		customer2.returnItem(shoes);
		customer2.buyItem(shoes);
		customer2.buyItem(herbtea);
		customer2.buyItem(eel);

		System.out.println(customer1 + "\n" + customer2);

		
		// Sort customer shoplist by product name (Comparable implementation)
		// PUT THIS IN CUSTOMER CLASS AS SORTING METHOD FOR TEACHER DEMONSTRATION
		System.out.println("\n\tBy name");
		shopCart2.shopListByName(); // Sort via its shopCart method 

		for (Product p : customer2.getShopCart().getShopList()) { // Print
			System.out.println(p);
		}
		
		
		// Sort customer shoplist by product price (calls Price-comparator)
		System.out.println("\n\tBy price");
		
		shopCart2.shopListByPrice(); // Sort via its shopCart method 
		for (Product p : customer2.getShopCart().getShopList()) { // Print
			System.out.println(p);
		}
		
		// Sort customer shoplist by product VAT (calls VAT-comparator)
		System.out.println("\n\tBy VAT");
		
		shopCart2.shopListByVat();  // Sort via its shopCart method
		for (Product p : customer2.getShopCart().getShopList()) { // Print
			System.out.println(p);
		}

	}

}
