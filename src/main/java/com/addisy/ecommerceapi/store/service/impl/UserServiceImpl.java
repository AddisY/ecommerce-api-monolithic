package com.addisy.ecommerceapi.store.service.impl;

import com.addisy.ecommerceapi.store.domian.PaymentCard;
import com.addisy.ecommerceapi.store.domian.ShoppingCart;
import com.addisy.ecommerceapi.store.domian.User;
import com.addisy.ecommerceapi.store.domian.UserShippingAddress;
import com.addisy.ecommerceapi.store.domian.UserRole;
import com.addisy.ecommerceapi.store.repository.PaymentCardRepository;
import com.addisy.ecommerceapi.store.repository.RoleRepository;
import com.addisy.ecommerceapi.store.repository.UserRepository;
import com.addisy.ecommerceapi.store.repository.UserShippingAddressRepository;
import com.addisy.ecommerceapi.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {



	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PaymentCardRepository paymentCardRepository;

	@Autowired
	private UserShippingAddressRepository userShippingAddressRepository;

	public User createUser(User user, Set<UserRole> userRoles) {
		User dbUser = userRepository.findByUsername(user.getUsername());

		if(dbUser == null) {

			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}

			user.getUserRoles().addAll(userRoles);

			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setUser(user);
			user.setShoppingCart(shoppingCart);

			user.setPaymentCardList(new ArrayList<PaymentCard>());
			user.setUserShippingAddressList(new ArrayList<UserShippingAddress>());

			dbUser = userRepository.save(user);
		}

		return dbUser;
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User save(User user)  {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public void removeUserById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}


}

