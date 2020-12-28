package com.addisy.ecommerceapi.store.service.impl;

import com.addisy.ecommerceapi.store.domian.Role;
import com.addisy.ecommerceapi.store.repository.RoleRepository;
import com.addisy.ecommerceapi.store.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findRoleByRoleName(String name) {
		return roleRepository.findByName(name);
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}
}
