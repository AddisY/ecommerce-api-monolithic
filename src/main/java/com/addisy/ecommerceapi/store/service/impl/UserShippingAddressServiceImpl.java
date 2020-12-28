package com.addisy.ecommerceapi.store.service.impl;

import com.addisy.ecommerceapi.store.domian.UserShippingAddress;
import com.addisy.ecommerceapi.store.repository.UserShippingAddressRepository;
import com.addisy.ecommerceapi.store.service.UserShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserShippingAddressServiceImpl implements UserShippingAddressService {

	@Autowired
	private UserShippingAddressRepository userShippingAddressRepository;

	public Optional<UserShippingAddress> findById(Long id) {
		return userShippingAddressRepository.findById(id);
	}

	public void removeById(Long id) {
		userShippingAddressRepository.deleteById(id);
	}

	@Override
	public UserShippingAddress save(UserShippingAddress userShippingAddress) {
		return userShippingAddressRepository.save(userShippingAddress);
	}

	@Override
	public List<UserShippingAddress> findAllByUserId(Long userId) {
		return (List<UserShippingAddress>)userShippingAddressRepository.findAllByUserId(userId);
	}

}
