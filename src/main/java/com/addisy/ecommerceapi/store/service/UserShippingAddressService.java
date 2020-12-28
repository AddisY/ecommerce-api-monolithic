package com.addisy.ecommerceapi.store.service;

import com.addisy.ecommerceapi.store.domian.UserShippingAddress;

import java.util.List;
import java.util.Optional;

public interface UserShippingAddressService {


	Optional<UserShippingAddress> findById(Long id);

	void removeById(Long id);

	UserShippingAddress save(UserShippingAddress userShippingAddress);

	List<UserShippingAddress> findAllByUserId(Long userId);

}
