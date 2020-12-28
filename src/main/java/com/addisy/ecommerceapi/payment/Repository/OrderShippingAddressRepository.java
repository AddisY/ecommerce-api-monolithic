package com.addisy.ecommerceapi.payment.Repository;

import com.addisy.ecommerceapi.payment.domain.OrderShippingAddress;
import org.springframework.data.repository.CrudRepository;

public interface OrderShippingAddressRepository extends CrudRepository<OrderShippingAddress, Long> {
}
