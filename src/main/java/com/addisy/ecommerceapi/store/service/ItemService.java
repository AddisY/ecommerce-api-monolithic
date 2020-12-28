package com.addisy.ecommerceapi.store.service;

import java.util.List;
import java.util.Optional;

import com.addisy.ecommerceapi.store.domian.Item;

public interface ItemService {

	List<Item> findAll();

	Optional<Item> findById(Long id);

	Item save(Item item);

	void removeOne(Long id);
}
