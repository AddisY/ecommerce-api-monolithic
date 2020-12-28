package com.addisy.ecommerceapi.store.service;

import com.addisy.ecommerceapi.store.domian.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

	Category save(Category category);

	Optional<Category> findCategoryById(Long id);

	void deleteCategoryById(Long id);

	List<Category> findAll();
}
