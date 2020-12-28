package com.addisy.ecommerceapi.store.repository;

import com.addisy.ecommerceapi.store.domian.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
