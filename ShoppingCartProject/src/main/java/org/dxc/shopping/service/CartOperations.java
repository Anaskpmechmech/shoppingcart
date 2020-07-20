package org.dxc.shopping.service;

import org.dxc.shopping.model.Product;

public interface CartOperations {
	float getInvoiceAmount();
	float addToCart(Product p) ;
	void removeFromCart(Product p);
}
