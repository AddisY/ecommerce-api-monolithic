package com.addisy.ecommerceapi.store.service.impl;

import com.addisy.ecommerceapi.store.domian.*;
import com.addisy.ecommerceapi.store.repository.CartItemRepository;
import com.addisy.ecommerceapi.store.repository.ItemToCartItemRepository;
import com.addisy.ecommerceapi.store.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;

	// Converts an Item into a CartItem and adds it into a ShoppingCart
	public CartItem convertItemToCartItem(Item item, User user, int quantity) {

		List<CartItem> cartItemList = findCartItemsByShoppingCart(user.getShoppingCart());

		for (CartItem cartItem : cartItemList) {

			// If the item is already in shopping cart
			if (item.getId() == cartItem.getItem().getId()) {
				cartItem.setQuantity(cartItem.getQuantity()+quantity);
				cartItem.setSubtotal(new BigDecimal(item.getPrice()).multiply(new BigDecimal(quantity)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}

		}

		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setItem(item);
		cartItem.setQuantity(quantity);
		cartItem.setSubtotal(new BigDecimal(item.getPrice()).multiply(new BigDecimal(quantity)));

		cartItem = cartItemRepository.save(cartItem);


		return cartItem;
	}

	public void removeCartItem(CartItem cartItem) {

		cartItemRepository.delete(cartItem);
	}

	public List<CartItem> findCartItemsByShoppingCart(ShoppingCart shoppingCart) {
		return cartItemRepository.findCartItemsByShoppingCart(shoppingCart);
	}

	public CartItem updateCartItem(CartItem cartItem) {
		BigDecimal subTotal = new BigDecimal(cartItem.getItem().getPrice()).multiply(new BigDecimal(cartItem.getQuantity()));
		cartItem.setSubtotal(subTotal);

		cartItemRepository.save(cartItem);

		return cartItem;

	}

	public Optional<CartItem> findById(Long id) {
		return cartItemRepository.findById(id);
	}

	public CartItem save(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

}
