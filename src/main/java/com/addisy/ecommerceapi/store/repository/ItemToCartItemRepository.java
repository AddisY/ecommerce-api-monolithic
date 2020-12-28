package com.addisy.ecommerceapi.store.repository;

import com.addisy.ecommerceapi.store.domian.CartItem;
import com.addisy.ecommerceapi.store.domian.ItemToCartItem;
import org.springframework.data.repository.CrudRepository;

public interface ItemToCartItemRepository {
	void deleteByCartItem(CartItem cartItem);

}
