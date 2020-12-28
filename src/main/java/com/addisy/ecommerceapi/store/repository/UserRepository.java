package com.addisy.ecommerceapi.store.repository;

import java.util.List;

import com.addisy.ecommerceapi.store.domian.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();

}
