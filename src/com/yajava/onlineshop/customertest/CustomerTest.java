package com.yajava.onlineshop.customertest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.yajava.onlineshop.customer.Customer;
import com.yajava.onlineshop.product.Product;
import com.yajava.onlineshop.shoppingcart.ShoppingCart;

class CustomerTest {

	Product candy = new Product(055, "Candy", 100, 25);
	Product apple = new Product(065, "Äpple", 100, 25);
	Product herbtea = new Product(075, "Örtte", 50, 25);
	
	
	@Test
	void test() {
		// Arrange (create shopCart and assign it to created/initiated customer)
		ShoppingCart shopCart1 = new ShoppingCart(); // Create shopping cart
		Customer customer1 = new Customer("Donald", "Duck", "Cairo", "070-7070707", 1, shopCart1);
		
		// Create temporary products to buy; and buy

		List<Product> availableProducts = new ArrayList<Product>(Arrays.asList(candy, apple, herbtea)); 

		customer1.buyItem(candy);
		customer1.buyItem(apple);
		customer1.buyItem(herbtea);
		
		// Act (
		String prodName1 = "Candy";
		String testProdName2 = "Äpple";
		int prodID = 05;
		String testProdName3 = "Örte";
		

		// Assert

//		assertEquals(teststart, race1.getRaceStart());
	}

}
