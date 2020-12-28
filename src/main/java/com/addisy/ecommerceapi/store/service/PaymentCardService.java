package com.addisy.ecommerceapi.store.service;

import com.addisy.ecommerceapi.store.domian.PaymentCard;

import java.util.List;
import java.util.Optional;

public interface PaymentCardService {

	Optional<PaymentCard> findById(Long id);

	void removeById(Long id);

	PaymentCard save(PaymentCard paymentCard);

	List<PaymentCard> findAllByUserId(Long userId);
}
