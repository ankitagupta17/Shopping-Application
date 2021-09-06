package com.cart.entity;

import java.util.List;

public class CategoryResponse {

        private String categoryName;
        private List<ItemEntity> itemEntityList;


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
