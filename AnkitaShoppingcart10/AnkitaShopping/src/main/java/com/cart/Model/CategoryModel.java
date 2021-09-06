package com.cart.Model;

import com.cart.entity.ItemEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class CategoryModel {
    private Integer categoryId;
    @NotBlank(message = "Category name is mandatory")
    private String categoryName;
    private List<ItemEntity> itemEntityList;
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ItemEntity> getItemEntityList() {
        return itemEntityList;
    }

    public void setItemEntityList(List<ItemEntity> itemEntityList) {
        this.itemEntityList = itemEntityList;
    }
}
