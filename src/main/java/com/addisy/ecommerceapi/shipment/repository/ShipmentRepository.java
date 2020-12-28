package com.addisy.ecommerceapi.shipment.repository;

import com.addisy.ecommerceapi.shipment.domain.Shipment;
import org.springframework.data.repository.CrudRepository;

public interface ShipmentRepository extends CrudRepository<Shipment, Long> {
}
