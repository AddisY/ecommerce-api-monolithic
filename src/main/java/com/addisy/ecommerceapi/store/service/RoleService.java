package com.addisy.ecommerceapi.store.service;

import com.addisy.ecommerceapi.store.domian.Role;

public interface RoleService{

	Role findRoleByRoleName(String name);

	Role save(Role role);

}
