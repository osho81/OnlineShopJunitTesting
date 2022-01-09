package com.yajava.onlineshop.producttest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.yajava.onlineshop.product.Product;

class ProductTest {

	@Test
	void testSetProductID() {

		// Arrange
		Product candy = new Product(1001, "Candy", 100, 25);
		candy.setProductID(1005);

		// Act
		int expectedProductID = 1005;

		// Assert
		assertEquals(expectedProductID, candy.getProductID());
	}

	@Test
	void testSetProductName() {

		// Arrange
		Product candy = new Product(1001, "Candy", 100, 25);
		candy.setProductName("BonBon");

		// Act
		String expectedProductName = "BonBon";

		// Assert
		assertEquals(expectedProductName, candy.getProductName());
	}

	@Test
	void testSetNetPrice() {

		// Arrange
		Product candy = new Product(1001, "Candy", 100, 25);
		candy.setNetPrice(200);

		// Act
		double expectedNetPrice = 200;

		// Assert
		assertEquals(expectedNetPrice, candy.getNetPrice());
	}

	@Test
	void testSetVatRate() {

		// Arrange
		Product candy = new Product(1001, "Candy", 100, 25);
		candy.setVatRate(30);

		// Act
		double expectedVatRate = 30.00;

		// Assert
		assertEquals(expectedVatRate, candy.getVatRate());
	}

	@Test
	void testEqualsObject() {

		// Arrange
		Product candy1 = new Product(1001, "Candy", 100, 25);
		Product candy2 = new Product(1001, "Candy", 100, 25);

		// Assert
		assertTrue(candy1.equals(candy2));
	}

	@Test
	void testToString() {

		// Arrange
		Product candy = new Product(1001, "Candy", 100, 25);

		// Act
		String expectedString = "Product ID: 1001         Product name: Candy  "
				+ "Net price: 100.00   VAT rate: 25.00%";
		expectedString = expectedString.replaceAll("\\s+", "");

		// Assert
		assertEquals(expectedString, candy.toString().replaceAll("\\s+", ""));
	}

	@Test
	void testCompareTo() {

		// Arrange
		Product candy1 = new Product(055, "Candy", 100, 25);
		Product candy2 = new Product(055, "Candy", 100, 25);
		Product apple = new Product(065, "Äpple", 100, 25);

		// Assert
		assertEquals(-1, candy1.compareTo(apple), "Meaning that Candy comes before Äpple in the Swedish alphabet");
		assertEquals(0, candy1.compareTo(candy2),
				"Meaning that Candy and Candy comes at same place in the Swedish alphabet");
		assertEquals(1, apple.compareTo(candy1), "Meaning that Apple comes after Candy in the Swedish alphabet");
	}

}
