package com.yajava.onlineshop.customertest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.yajava.onlineshop.customer.Customer;
import com.yajava.onlineshop.product.Product;
import com.yajava.onlineshop.shoppingcart.ShoppingCart;

class CustomerTest {

	@Test
	void testSetShopCart() {

		// Arrange
		ShoppingCart shopCart1 = new ShoppingCart();
		ShoppingCart shopCart2 = new ShoppingCart();
		Customer customer1 = new Customer("Donald", "Duck", "Oslo", "070-7070707", 7, shopCart1);
		customer1.setShopCart(shopCart2);

		// Act
		ShoppingCart expectedShopCart = shopCart2;

		// Assert
		assertEquals(expectedShopCart, customer1.getShopCart());
	}

	@Test
	void testSetCustomerID() {

		// Arrange
		Customer customer1 = new Customer("Donald", "Duck", "Oslo", "070-7070707", 9876, null);

		// Act
		int expectedCusomerID = 9876;

		// Assert
		assertEquals(expectedCusomerID, customer1.getCustomerID());
	}

	@Test
	void testBuyItem() {

		// Arrange
		ShoppingCart shopCart1 = new ShoppingCart();
		Customer customer1 = new Customer("Donald", "Duck", "Oslo", "070-7070707", 7, shopCart1);
		Product candy = new Product(1001, "Candy", 100, 25);
		Product apple = new Product(065, "Äpple", 200, 10);
		customer1.buyItem(candy);
		customer1.buyItem(apple);

		// Act
		Product expectedProduct1 = candy;
		Product expectedProduct2 = apple;

		// Assert
		assertEquals(expectedProduct1, customer1.getShopCart().getShopList().get(0));
		assertEquals(expectedProduct2, customer1.getShopCart().getShopList().get(1));
	}

	@Test
	void testReturnItem() {

		// Arrange
		ShoppingCart shopCart1 = new ShoppingCart();
		Customer customer1 = new Customer("Donald", "Duck", "Oslo", "070-7070707", 7, shopCart1);
		Product candy = new Product(1001, "Candy", 100, 25);
		customer1.buyItem(candy);
		customer1.returnItem(candy);

		// Assert
		assertTrue(customer1.getShopCart().getShopList().size() == 0);
	}

	@Test
	void testEqualsObject() {

		// Arrange
		ShoppingCart shopCart1 = new ShoppingCart();
		ShoppingCart shopCart2 = new ShoppingCart();
		Customer customer1 = new Customer("Donald", "Duck", "Cairo", "070-7070707", 9876, shopCart1);
		Customer customer2 = new Customer("Donald", "Duck", "Cairo", "070-7070707", 9876, shopCart1);
		Customer customer3 = new Customer("Mickey", "Mouse", "London", "070-8080808", 4321, shopCart2);

		// Assert
		assertTrue(customer1.equals(customer2));
		assertFalse(customer1.equals(customer3));
	}

	@Test
	void testToString() {

		// Arrange
		ShoppingCart shopCart1 = new ShoppingCart();
		Customer customer1 = new Customer("Donald", "Duck", "Oslo", "070-7070707", 7, shopCart1);
		Product candy = new Product(1001, "Candy", 100, 25);
		customer1.buyItem(candy);

		// Act
		String expectedString = "Customer number: 7		Name: Donald Duck	"
				+ "PhoneNumber: 070-7070707\n ShoppingCart:\n"
				+ "Product 1: Product ID: 1001         Product name: Candy   "
				+ "Net price: 100.00   VAT rate: 25.00%\r\n"
				+ "Amount excl. VAT: 100.00		Amount incl. VAT: 125.00";
		expectedString = expectedString.replaceAll("\\s+", "");

		// Assert
		assertEquals(expectedString, customer1.toString().replaceAll("\\s+", ""));
	}

}
