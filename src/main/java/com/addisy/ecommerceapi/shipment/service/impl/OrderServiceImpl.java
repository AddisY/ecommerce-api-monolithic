package com.addisy.ecommerceapi.shipment.service.impl;

import com.addisy.ecommerceapi.store.domian.*;
import com.addisy.ecommerceapi.shipment.domain.Order;
import com.addisy.ecommerceapi.payment.domain.OrderPayment;
import com.addisy.ecommerceapi.shipment.repository.OrderRepository;
import com.addisy.ecommerceapi.payment.Repository.OrderShippingAddressRepository;
import com.addisy.ecommerceapi.store.service.CartItemService;
import com.addisy.ecommerceapi.shipment.service.OrderService;
import com.addisy.ecommerceapi.payment.domain.OrderShippingAddress;
import com.addisy.ecommerceapi.shipment.service.ShipmentService;
import com.addisy.ecommerceapi.shipment.domain.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ShipmentService shipmentService;

	@Autowired
	private OrderShippingAddressRepository orderShippingAddressRepository;

	public Order createOrder(ShoppingCart shoppingCart, UserShippingAddress userShippingAddress, PaymentCard paymentCard, User user){

		Order order = new Order();
		OrderShippingAddress orderShippingAddress = new OrderShippingAddress();
		OrderPayment orderPayment = new OrderPayment();
		Shipment shipment =new Shipment();

		List<CartItem> cartItemList = cartItemService.findCartItemsByShoppingCart(shoppingCart);

		for (CartItem cartItem : cartItemList) {
			cartItem.setOrder(order);
			Item item = cartItem.getItem();
			item.setQntInStock(item.getQntInStock()-cartItem.getQuantity());
		}

		orderShippingAddress.setUserShippingAddress(userShippingAddress);

		orderPayment.setPaymentCard(paymentCard);
		orderPayment.setOrder(order);
		order.setOrderPayment(orderPayment);

		shipment.setOrderShippingAddress(orderShippingAddress);
		shipment.setDepartureDate(Calendar.getInstance().getTime());
		shipment.setShippingStatus("Active");
		shipment.setOrder(order);

		order.setCartItemList(cartItemList);
		order.setTotalPrice(shoppingCart.getTotalPrice());
		order.setUser(user);
		order.setShipment(shipment);
		order = orderRepository.save(order);

		shipmentService.save(shipment);

		return order;
	}

	public Optional<Order> findOrderById(Long id) {
		return orderRepository.findById(id);
	}

	public Order saveOrder(Order order){
		return orderRepository.save(order);
	}

}

