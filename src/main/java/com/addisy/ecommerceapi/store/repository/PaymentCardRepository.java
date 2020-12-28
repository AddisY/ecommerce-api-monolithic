package com.addisy.ecommerceapi.store.repository;

import com.addisy.ecommerceapi.store.domian.PaymentCard;
import org.springframework.data.repository.CrudRepository;

public interface PaymentCardRepository extends CrudRepository<PaymentCard, Long> {

	Iterable<PaymentCard> findAllByUserId(Long userId);
}
