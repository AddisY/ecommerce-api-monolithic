package com.addisy.ecommerceapi.store.controller;

import com.addisy.ecommerceapi.store.domian.PaymentCard;
import com.addisy.ecommerceapi.store.domian.User;
import com.addisy.ecommerceapi.store.service.PaymentCardService;
import com.addisy.ecommerceapi.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/paymentCard")
public class PaymentCardController {

	@Autowired
	private UserService userService;

	@Autowired
	private PaymentCardService paymentCardService;

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Map<String,Object> addNewPaymentCard (
			@RequestBody PaymentCard paymentCard,
			Principal principal) {

		User user = userService.findUserByUsername(principal.getName());


		paymentCard.setUser(user);

		PaymentCard paymentCard1 = paymentCardService.save(paymentCard);

		Map<String,Object> response = new HashMap<>();

		response.put("message", "Added successfully!");
		response.put("paymentCard", paymentCard1);

		return response;
	}

	@RequestMapping(value="/{id}")
	public PaymentCard getPaymentCard(
			@PathVariable("id") Long id
	) {
		return paymentCardService.findById(id).orElse(null);
	}

	@RequestMapping(value="/delete/{id}")
	public Map<String,String> removePaymentCard(
			@PathVariable("id") Long id
	){

		paymentCardService.removeById(id);

		return Collections.singletonMap("message","Payment card removed");
	}

	@RequestMapping("/list/{userId}")
	public List<PaymentCard> getPaymentCardList(
			@PathVariable("userId") Long userId
	){

		List<PaymentCard> paymentCardlist = paymentCardService.findAllByUserId(userId);

		return paymentCardlist;
	}

}

