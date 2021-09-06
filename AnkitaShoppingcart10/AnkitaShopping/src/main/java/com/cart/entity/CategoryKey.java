package com.cart.entity;

import java.io.Serializable;
import java.util.Objects;

public class CategoryKey implements Serializable {

        private String itemName;
        private Integer itemId;
        private CategoryEntity category;

    public CategoryKey(Integer itemId, String itemName, CategoryEntity category) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category =category;

    }
    public CategoryKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryKey)) return false;
        CategoryKey that = (CategoryKey) o;
        return Objects.equals(itemName, that.itemName) && Objects.equals(itemId, that.itemId) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemId, category);
    }
}
