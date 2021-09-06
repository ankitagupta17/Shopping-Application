package com.cart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.lang.NonNull;

import javax.persistence.*;
//@IdClass(CategoryKey.class)
@Entity
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;
//    @Id
    private String itemName;
    private Integer itemPrice;
//    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="CATEGORY_ID", nullable=false)
    private CategoryEntity category;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

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

    @Override
    public String toString() {
        return "ItemEntity{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", category=" + category +
                '}';
    }
}