package com.addisy.ecommerceapi.store.repository;

import com.addisy.ecommerceapi.store.domian.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
