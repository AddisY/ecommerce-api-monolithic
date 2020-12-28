package com.addisy.ecommerceapi.store.controller;


import com.addisy.ecommerceapi.store.domian.UserShippingAddress;
import com.addisy.ecommerceapi.store.domian.User;
import com.addisy.ecommerceapi.store.service.UserShippingAddressService;
import com.addisy.ecommerceapi.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userShippingAddress")
public class UserShippingAddressController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserShippingAddressService userShippingAddressService;

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Map<String,Object> addNewUserShippingAddress(
			@RequestBody UserShippingAddress userShippingAddress, Principal principal
	) {
		User user = userService.findUserByUsername(principal.getName());

		userShippingAddress.setUser(user);

		UserShippingAddress userShippingAddress1 = userShippingAddressService.save(userShippingAddress);

		Map<String,Object> response = new HashMap<>();

		response.put("message", "Added successfully!");
		response.put("userSippingAddress", userShippingAddress1);

		return response;
	}

	@RequestMapping(value="/{id}")
	public UserShippingAddress getUserShippingAddress(
			@PathVariable("id") Long id
	) {
		return userShippingAddressService.findById(id).orElse(null);
	}

	@RequestMapping("/list/{id}")
	public List<UserShippingAddress> getUserShippingAddressList(
			@PathVariable("id") Long id
	){

		List<UserShippingAddress> userShippingAddressList = userShippingAddressService.findAllByUserId(id);

		return userShippingAddressList;
	}

	@RequestMapping(value="/delete/{id}")
	public Map<String,String> removeUserShippingAddress(
			@PathVariable("id") Long id
	) {
		userShippingAddressService.removeById(id);
		return Collections.singletonMap("message", "Shipping address removed");
	}

}

