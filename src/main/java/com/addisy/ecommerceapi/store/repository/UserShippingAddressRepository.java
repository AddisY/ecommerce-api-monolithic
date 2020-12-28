package com.addisy.ecommerceapi.store.repository;

import com.addisy.ecommerceapi.store.domian.UserShippingAddress;
import org.springframework.data.repository.CrudRepository;

public interface UserShippingAddressRepository extends CrudRepository<UserShippingAddress, Long> {

	Iterable<UserShippingAddress> findAllByUserId(Long userId);
}
