package com.addisy.ecommerceapi.store.service;

import com.addisy.ecommerceapi.store.domian.User;
import com.addisy.ecommerceapi.store.domian.UserRole;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface UserService {

	User createUser(User user, Set<UserRole> userRoles);

	User findUserByUsername(String username);

	User findByEmail (String email);

	User save(User user);

	Optional<User> findById(Long id);

	void removeUserById(Long id);

	List<User> findAll();


}
