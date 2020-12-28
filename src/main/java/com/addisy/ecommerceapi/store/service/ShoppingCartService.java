package com.addisy.ecommerceapi.store.service;

import com.addisy.ecommerceapi.store.domian.ShoppingCart;
import com.addisy.ecommerceapi.store.domian.User;

public interface ShoppingCartService {

	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

	void clearShoppingCart(ShoppingCart shoppingCart);

	ShoppingCart findByUser(User user);

}
