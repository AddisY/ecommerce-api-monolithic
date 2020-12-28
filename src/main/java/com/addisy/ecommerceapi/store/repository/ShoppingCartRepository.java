package com.addisy.ecommerceapi.store.repository;

import com.addisy.ecommerceapi.store.domian.ShoppingCart;
import com.addisy.ecommerceapi.store.domian.User;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

	ShoppingCart findByUser(User user);

}
