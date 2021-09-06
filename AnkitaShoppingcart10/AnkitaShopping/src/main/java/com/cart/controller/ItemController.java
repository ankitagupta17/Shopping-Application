package com.cart.controller;

import com.cart.Exceptions.CategoryNotFoundException;
import com.cart.Exceptions.GenericException;
import com.cart.Model.ItemModel;
import com.cart.entity.CategoryEntity;
import com.cart.entity.CategoryResponse;
import com.cart.entity.ItemEntity;
import com.cart.Model.CategoryModel;
import com.cart.entity.ItemResponse;
import com.cart.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Configuration
@PropertySource("classpath:app.properties")
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private Environment env;

    @Value("${message}")
    private String message;


    @PostMapping("/addItems")
    public ResponseEntity<String> addItems(@Validated @RequestBody ItemModel items, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()) {
            try {
                itemService.addItems(items);
            }
            catch (Exception e){
                throw new GenericException(e.getMessage());
            }
        } else {
            return new ResponseEntity<String>("Field Required", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(env.getProperty("ITEM_ADDED"), HttpStatus.OK);
    }

    @PostMapping("/addCategory")
    public ResponseEntity<String> addCategory(@Validated @RequestBody CategoryModel category, BindingResult bindingResult) {
        System.out.println("aa "+message);
        if(!bindingResult.hasErrors()) {
            try {
                itemService.addCategory(category);
            }
            catch (Exception e){
                throw new GenericException(e.getMessage());
            }
        } else {
            return new ResponseEntity<String>("Field Required", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Category SuccessFully Added", HttpStatus.OK);
    }

    @GetMapping("/getData")
    public HashMap<String, List> getCategory(){
       return itemService.getCategory();
    }

    @GetMapping(path="/findCategorybyid/{cid}")
    public Optional<CategoryEntity> findCategoryByid(@PathVariable int cid)
    {
        return itemService.findCategoryByid(cid);
    }

    @GetMapping(path="/findItembyid/{cid}")
    public Optional<ItemEntity> findItemByid(@PathVariable int cid)
    {
        return itemService.findItemByid(cid);
    }

    @DeleteMapping(path="/deleteCategorybyid/{cid}")
    public ResponseEntity<String> deleteCategory(@PathVariable int cid){
        itemService.deleteCategory(cid);
        return new ResponseEntity<>("SuccesssFully Deleted the category", HttpStatus.OK);
    }

    @DeleteMapping(path="/deleteItems/{itemId}")
    public ResponseEntity<String> deleteItems(@PathVariable int itemId)  {
            itemService.deleteItem(itemId);
            return new ResponseEntity<>("SuccesssFully Deleted the item", HttpStatus.OK);
    }

    @PutMapping("/updatecategory/{id}")
    public Optional<CategoryResponse> updateCategory(@PathVariable(value = "id") Integer categoryid,
                                                     @RequestBody CategoryModel categoryDetails) throws Exception {

        return itemService.updateCategory(categoryid, categoryDetails);
    }

//    @PutMapping("/updateItem/{id}")
//    public ItemEntity updateItem(@PathVariable(value = "id") Integer itemid,
//                                         @RequestBody ItemEntity itemDetails) throws Exception {
//        return itemService.updateItem(itemid, itemDetails);
//    }

    @PutMapping("/updateItem/{id}")
    public Optional<ItemResponse> updateItem(@PathVariable(value = "id") Integer itemid,
                                             @RequestBody ItemModel itemDetails) throws Exception {
        return itemService.updateItem(itemid, itemDetails);
    }

    @GetMapping("/getDataByCategory")
    public void getDatabyCategory(){

    }
}
