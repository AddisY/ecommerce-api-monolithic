package com.addisy.ecommerceapi.store.controller;

import com.addisy.ecommerceapi.store.domian.Category;
import com.addisy.ecommerceapi.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping (value="/add", method= RequestMethod.POST)
	public Map<String,Object> addCategory(@RequestBody Category category) {

		Category category1 = categoryService.save(category);

		Map<String,Object> response = new HashMap<>();

		response.put("message", "Category added successfully");
		response.put("category", category1);

		return response;
	}

	@RequestMapping("/list")
	public List<Category> getCategoryList() {
		return categoryService.findAll();
	}

	@RequestMapping("/{id}")
	public Category getCategory(@PathVariable("id") Long id){
		Category category = categoryService.findCategoryById(id).orElse(null);
		return category;
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public Map<String, Object> updateCategory(@RequestBody Category category) {

		Category category1 = categoryService.save(category);

		Map<String,Object> response = new HashMap<>();

		response.put("message", "update successful!");
		response.put("category", category1);

		return response;
	}

	@RequestMapping(value="/delete/{id}")
	public Map<String, String> delete(@PathVariable("id") Long id) {

		categoryService.deleteCategoryById(id);

		return Collections.singletonMap("message", "category removed");
	}


}
