package com.cart.Model;


import com.cart.entity.CategoryEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemModel {
    @NotBlank(message = "Item name is mandatory")
    private String itemName;
    @NotNull(message = "Item Price is mandatory")
    private Integer itemPrice;
    @NotNull(message = "Item category is mandatory")
    private CategoryEntity category;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}