package com.addisy.ecommerceapi.shipment.repository;

import com.addisy.ecommerceapi.shipment.domain.Order;
import com.addisy.ecommerceapi.store.domian.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
	List<Order> findByUser(User user);
}
