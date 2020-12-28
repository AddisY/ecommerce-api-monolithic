package com.addisy.ecommerceapi.store.service.impl;

import com.addisy.ecommerceapi.store.domian.CartItem;
import com.addisy.ecommerceapi.store.domian.ShoppingCart;
import com.addisy.ecommerceapi.store.domian.User;
import com.addisy.ecommerceapi.store.repository.ShoppingCartRepository;
import com.addisy.ecommerceapi.store.service.CartItemService;
import com.addisy.ecommerceapi.store.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
		BigDecimal totalPrice = new BigDecimal(0);

		List<CartItem> cartItemList = cartItemService.findCartItemsByShoppingCart(shoppingCart);

		for (CartItem cartItem : cartItemList) {
			if(cartItem.getItem().getQntInStock()>0) {
				cartItemService.updateCartItem(cartItem);
				totalPrice = totalPrice.add(cartItem.getSubtotal());
			}
		}

		shoppingCart.setTotalPrice(totalPrice);

		shoppingCartRepository.save(shoppingCart);

		return shoppingCart;
	}

	public void clearShoppingCart(ShoppingCart shoppingCart) {
		List<CartItem> cartItemList = cartItemService.findCartItemsByShoppingCart(shoppingCart);

		for(CartItem cartItem : cartItemList) {
			cartItem.setShoppingCart(null);
			cartItemService.save(cartItem);
		}

		shoppingCart.setTotalPrice(new BigDecimal(0));

		shoppingCartRepository.save(shoppingCart);
	}

	@Override
	public ShoppingCart findByUser(User user) {
		return shoppingCartRepository.findByUser(user);
	}
}
