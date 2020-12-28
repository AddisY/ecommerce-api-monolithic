package com.addisy.ecommerceapi.store.repository;

import com.addisy.ecommerceapi.store.domian.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByName(String name);

}
