package com.addisy.ecommerceapi.store.service.impl;

import com.addisy.ecommerceapi.store.domian.Category;
import com.addisy.ecommerceapi.store.repository.CategoryRepository;
import com.addisy.ecommerceapi.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Optional<Category> findCategoryById(Long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public void deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public List<Category> findAll() {
		return (List<Category>)categoryRepository.findAll();
	}
}
