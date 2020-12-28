package com.addisy.ecommerceapi.payment.controller;

import com.addisy.ecommerceapi.shipment.domain.Order;
import com.addisy.ecommerceapi.store.domian.*;
import com.addisy.ecommerceapi.shipment.service.OrderService;
import com.addisy.ecommerceapi.store.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CheckoutController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private UserShippingAddressService userShippingAddressService;

	@Autowired
	private PaymentCardService paymentCardService;

	@RequestMapping(value = "/checkout", method=RequestMethod.POST)
	public Map<String,Object> checkout(@RequestBody HashMap<String, Object> mapper, Principal principal){

		String userShippingAddressId = String.valueOf(mapper.get("userShippingAddressId"));

		UserShippingAddress userShippingAddress = userShippingAddressService.findById(Long.parseLong(userShippingAddressId)).orElse(null);

		String paymentCardId = String.valueOf(mapper.get("paymentCardId"));
		PaymentCard paymentCard = paymentCardService.findById(Long.parseLong(paymentCardId)).orElse(null);

		if (userShippingAddress==null){
			return Collections.singletonMap("message", "Shipping address not found");
		}

		if (paymentCard==null){
			return Collections.singletonMap("message", "Payment card not found");
		}

		ShoppingCart shoppingCart = userService.findUserByUsername(principal.getName()).getShoppingCart();
		User user = userService.findUserByUsername(principal.getName());
		Order order = orderService.createOrder(shoppingCart, userShippingAddress, paymentCard, user);

		shoppingCartService.clearShoppingCart(shoppingCart);

		Map<String,Object> response = new HashMap<>();

		response.put("message", "Checkout successful!!!");
		response.put("order", order);

		return response;

	}

}

