package com.addisy.ecommerceapi.store.repository;

import com.addisy.ecommerceapi.store.domian.CartItem;
import com.addisy.ecommerceapi.store.domian.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {

	List<CartItem> findCartItemsByShoppingCart(ShoppingCart shoppingCart);

}
