package com.addisy.ecommerceapi.shipment.controller;

import com.addisy.ecommerceapi.store.domian.*;
import com.addisy.ecommerceapi.shipment.domain.Order;
import com.addisy.ecommerceapi.shipment.service.OrderService;
import com.addisy.ecommerceapi.store.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private UserService userService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private OrderService orderService;

	@RequestMapping(value="/{id}")
	public Optional<Order> getOrder(@PathVariable("id") Long id) {

		return orderService.findOrderById(id);
	}

	@RequestMapping("/getOrderHistory")
	public List<Order> getOrderHistory(Principal principal) {

		User user = userService.findUserByUsername(principal.getName());
		List<Order> orderList = user.getOrderList();

		return orderList;
	}

}

