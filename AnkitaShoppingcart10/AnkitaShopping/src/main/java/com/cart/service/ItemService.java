package com.cart.service;

import com.cart.Model.ItemModel;
import com.cart.entity.CategoryEntity;
import com.cart.entity.CategoryResponse;
import com.cart.entity.ItemEntity;
import com.cart.Model.CategoryModel;
import com.cart.entity.ItemResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface ItemService {
    String addItems(ItemModel items);
    String addCategory(CategoryModel category);
    HashMap<String, List> getCategory();
    void deleteCategory(Integer cid);
    Optional<CategoryEntity> findCategoryByid(Integer cid);
    public Optional<CategoryResponse> updateCategory(Integer id, CategoryModel categoryDetails) throws Exception;
    Optional<ItemEntity> findItemByid(Integer cid);
    void deleteItem(Integer itemId);
    Optional<ItemResponse> updateItem(Integer id, ItemModel itemDetails) throws Exception;
}
