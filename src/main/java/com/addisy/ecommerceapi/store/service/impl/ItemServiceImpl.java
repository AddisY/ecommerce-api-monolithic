package com.addisy.ecommerceapi.store.service.impl;

import com.addisy.ecommerceapi.store.domian.Item;
import com.addisy.ecommerceapi.store.repository.ItemRepository;
import com.addisy.ecommerceapi.store.service.ItemService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> findAll() {
		List<Item> itemList = (List<Item>) itemRepository.findAll();

		return itemList;

	}

	public Optional<Item> findById(Long id) {
		return itemRepository.findById(id);
	}

	public Item save(Item item) {
		return itemRepository.save(item);
	}

	public void removeOne(Long id) {
		itemRepository.deleteById(id);
	}

}
