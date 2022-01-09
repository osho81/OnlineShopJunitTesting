package com.yajava.onlineshop.shoppingcarttest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.yajava.onlineshop.product.Product;
import com.yajava.onlineshop.shoppingcart.ShoppingCart;

class ShoppingCartTest {

	@Test
	void testAddToShopList() {

		// Arrange
		Product candy = new Product(1001, "Candy", 100, 25);
		ShoppingCart shopCart1 = new ShoppingCart();
		shopCart1.addToShopList(candy);

		// Act
		Product expectedProduct = candy;

		// Assert
		assertEquals(expectedProduct, shopCart1.getShopList().get(0));
	}

	@Test
	void testRemoveFromShopList() {

		// Arrange
		Product candy = new Product(1001, "Candy", 100, 25);
		ShoppingCart shopCart1 = new ShoppingCart();
		shopCart1.addToShopList(candy);
		shopCart1.removeFromShopList(candy);

		// Assert
		assertTrue(shopCart1.getShopList().size() == 0);
	}

	@Test
	void testSetAmountExclVat() {

		// Arrange
		Product candy = new Product(1001, "Candy", 100, 25);
		Product apple = new Product(065, "Äpple", 200, 10);
		ShoppingCart shopCart1 = new ShoppingCart();
		shopCart1.addToShopList(candy);
		shopCart1.addToShopList(apple);

		// Act
		double expectedAmountExclVat = 300.0;

		// Assert
		assertEquals(expectedAmountExclVat, shopCart1.getAmountExclVat());
	}

	@Test
	void testSetAmountInclVat() {

		// Arrange
		Product candy = new Product(1001, "Candy", 100, 25);
		Product apple = new Product(065, "Äpple", 200, 10);
		ShoppingCart shopCart1 = new ShoppingCart();
		shopCart1.addToShopList(candy);
		shopCart1.addToShopList(apple);

		// Act
		double expectedAmountInclVat = 345.0;

		// Assert
		assertEquals(expectedAmountInclVat, shopCart1.getAmountInclVat());
	}

	@Test
	void testEqualsObject() {

		// Arrange
		Product candy = new Product(1001, "Candy", 100, 25);
		Product apple = new Product(065, "Äpple", 200, 10);
		ShoppingCart shopCart1 = new ShoppingCart();
		ShoppingCart shopCart2 = new ShoppingCart();
		ShoppingCart shopCart3 = new ShoppingCart();
		shopCart1.addToShopList(candy);
		shopCart2.addToShopList(candy);
		shopCart3.addToShopList(apple);

		// Assert
		assertTrue(shopCart1.equals(shopCart2));
		assertFalse(shopCart1.equals(shopCart3));
	}

	@Test
	void testToString() {

		// Arrange
		Product candy = new Product(1001, "Candy", 100, 25);
		ShoppingCart shopCart1 = new ShoppingCart();
		shopCart1.addToShopList(candy);

		// Act
		String expectedString = "ShoppingCart: Product 1: Product ID: 1001 "
				+ "Product name: Candy      Net price: 100.00  " + "VAT rate: 25.00% Amount excl. VAT: 100.00 "
				+ "Amount incl. VAT: 125.00";
		expectedString = expectedString.replaceAll("\\s+", "");

		// Assert
		assertEquals(expectedString, shopCart1.toString().replaceAll("\\s+", ""));
	}

	@Test
	void testShopListByName() {
		
		// Arrange
		Product candy = new Product(1001, "Candy", 100, 25);
		Product apple = new Product(065, "Äpple", 200, 10);
		ShoppingCart shopCart1 = new ShoppingCart();
		shopCart1.addToShopList(apple);
		shopCart1.addToShopList(candy);

		// Act
		shopCart1.shopListByName();
		Product expectedFirstProduct = candy;
		Product expectedLastProduct = apple;

		// Assert
		assertEquals(expectedFirstProduct, shopCart1.getShopList().get(0));
		assertEquals(expectedLastProduct, shopCart1.getShopList().get(1));
	}

	@Test
	void testShopListByPrice() { // External comparator

		// Arrange
		Product candy = new Product(1001, "Candy", 100, 25);
		Product apple = new Product(065, "Äpple", 200, 10);
		ShoppingCart shopCart1 = new ShoppingCart();
		shopCart1.addToShopList(apple);
		shopCart1.addToShopList(candy); // Cheapest

		// Act
		shopCart1.shopListByPrice();
		Product expectedFirstProduct = candy;
		Product expectedLastProduct = apple;

		// Assert
		assertEquals(expectedFirstProduct, shopCart1.getShopList().get(0));
		assertEquals(expectedLastProduct, shopCart1.getShopList().get(1));
	}

	@Test
	void testShopListByVat() { // External comparator

		// Arrange
		Product candy = new Product(1001, "Candy", 100, 25);
		Product apple = new Product(065, "Äpple", 200, 10);
		ShoppingCart shopCart1 = new ShoppingCart();
		shopCart1.addToShopList(apple); // Lowest VAT
		shopCart1.addToShopList(candy);

		// Act
		shopCart1.shopListByVat();
		Product expectedFirstProduct = apple;
		Product expectedLastProduct = candy;

		// Assert
		assertEquals(expectedFirstProduct, shopCart1.getShopList().get(0));
		assertEquals(expectedLastProduct, shopCart1.getShopList().get(1));
	}

}
