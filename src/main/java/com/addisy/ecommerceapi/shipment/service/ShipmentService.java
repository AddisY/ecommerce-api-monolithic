package com.addisy.ecommerceapi.shipment.service;

import com.addisy.ecommerceapi.shipment.domain.Shipment;

import java.util.List;
import java.util.Optional;

public interface ShipmentService {

	List<Shipment> findAll();

	Optional<Shipment> findById(Long id);

	Shipment save(Shipment item);

	void removeOne(Long id);
}
