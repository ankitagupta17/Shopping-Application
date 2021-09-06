package com.cart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;

    @Column(unique = true)
    private String categoryName;

    @JsonManagedReference
    @OneToMany(mappedBy="category")
    @JsonProperty("contacts")
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

    public CategoryEntity(String categoryName) {
        this.categoryName = categoryName;
    }
    public CategoryEntity() {

    }
}