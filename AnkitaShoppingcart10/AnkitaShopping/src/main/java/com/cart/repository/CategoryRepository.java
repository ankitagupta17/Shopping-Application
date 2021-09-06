package com.cart.repository;

import com.cart.entity.CategoryEntity;
import com.cart.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {

}
