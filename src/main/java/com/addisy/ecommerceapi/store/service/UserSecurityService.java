package com.addisy.ecommerceapi.store.service;

import com.addisy.ecommerceapi.store.domian.User;
import com.addisy.ecommerceapi.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserSecurityService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(null == user) {
			throw new UsernameNotFoundException("Username "+username+" not found");
		}
		return user;
	}
}
