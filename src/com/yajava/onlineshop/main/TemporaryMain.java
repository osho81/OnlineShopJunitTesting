package com.yajava.onlineshop.main;

import com.yajava.onlineshop.person.customer.Customer;
import com.yajava.onlineshop.product.Product;
import com.yajava.onlineshop.shoppingcart.ShoppingCart;

public class TemporaryMain {

	public static void main(String[] args) {

		
		Product shoes = new Product(35, "Milk", 700, 10);
		Product pants = new Product(45, "Milk", 400, 15);
		Product candy = new Product(55, "Milk", 50, 25);
		
		ShoppingCart shopCart7 = new ShoppingCart();
		ShoppingCart shopCart12 = new ShoppingCart();
		
		shopCart7.setProductList(shoes);
		shopCart7.setProductList(pants);
		shopCart7.setProductList(candy);
		shopCart7.setProductList(candy);
		//

		Customer customer7 = new Customer("Donald", "Duck", "070-7070707", 7, shopCart7);
		Customer customer12 = new Customer("Mickey", "Mouse", "070-6060606", 12, shopCart12);
		
		
		
		System.out.println(customer7 + "\n" + customer12);
		

	}

}
