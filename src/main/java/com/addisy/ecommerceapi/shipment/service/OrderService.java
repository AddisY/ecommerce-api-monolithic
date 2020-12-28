package com.addisy.ecommerceapi.shipment.service;

import com.addisy.ecommerceapi.store.domian.*;
import com.addisy.ecommerceapi.shipment.domain.Order;

import java.util.Optional;

public interface OrderService {

	Order createOrder(ShoppingCart shoppingCart, UserShippingAddress userShippingAddress, PaymentCard paymentCard, User user
	);

	Order saveOrder(Order order);
	Optional<Order> findOrderById(Long id);
}
