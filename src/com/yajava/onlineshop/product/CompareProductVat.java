package com.yajava.onlineshop.product;

import java.util.Comparator;

/**
 * Class used for sorting shopping list by product VAT.
 * See methods in shoppingCart applying this external comparator.
 */

public class CompareProductVat implements Comparator<Product> {

	@Override
	public int compare(Product prod1, Product prod2) {
        if (prod1.getVatRate() < prod2.getVatRate()) {
            return -1;
        } else if (prod1.getVatRate() > prod2.getVatRate()) {
            return 1;
        } else {
            return 0;
        }
	}

}
