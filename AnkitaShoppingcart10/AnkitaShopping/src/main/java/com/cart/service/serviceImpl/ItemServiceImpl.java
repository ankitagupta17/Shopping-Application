package com.cart.service.serviceImpl;

import com.cart.Exceptions.CategoryNotFoundException;
import com.cart.Model.ItemModel;
import com.cart.entity.CategoryEntity;
import com.cart.entity.CategoryResponse;
import com.cart.entity.ItemEntity;
import com.cart.entity.ItemResponse;
import com.cart.repository.CategoryRepository;
import com.cart.repository.ItemRepository;
import com.cart.Model.CategoryModel;
import com.cart.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Configuration
@PropertySource("/app.properties")
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Environment env;

    @Override
    public String addItems(ItemModel items) {
        ModelMapper modelMapper=new ModelMapper();
        ItemEntity itemEntity=modelMapper.map(items, ItemEntity.class);
        itemRepository.save(itemEntity);
        return "Items added successfully.";
    }

    @Override
    public String addCategory(CategoryModel category) {
        ModelMapper modelMapper=new ModelMapper();
        CategoryEntity categoryEntity=modelMapper.map(category, CategoryEntity.class);
        categoryRepository.save(categoryEntity);
        return "Successfully added.";
    }

    @Override
    public HashMap<String, List> getCategory()
    {
        Iterable<CategoryEntity> i = categoryRepository.findAll();
        HashMap<String, List> map = new HashMap<>();
        List<CategoryEntity> list = StreamSupport.stream(i.spliterator(), true).collect(Collectors.toList());
        for (CategoryEntity ce : list) {
            map.put(ce.getCategoryName(), ce.getItemEntityList());
        }
        return map;

}

    @Override
    public Optional<CategoryEntity> findCategoryByid(Integer cid)
    {
        return categoryRepository.findById(cid);

    }

    @Override
    public Optional<ItemEntity> findItemByid(Integer cid)
    {
        return itemRepository.findById(cid);
    }

    @Override
    public void deleteCategory(Integer cid)
    {
        categoryRepository.deleteById(cid);
    }

    @Override
    public void deleteItem(Integer itemId)
    {
        itemRepository.deleteById(itemId);
    }


    @Override
    public Optional<CategoryResponse> updateCategory(Integer id, CategoryModel categoryDetails) throws Exception {
        ModelMapper modelMapper=new ModelMapper();
        CategoryEntity categoryEntity=modelMapper.map(categoryDetails, CategoryEntity.class);
        return categoryRepository.findById(id).map(categoryvalue->{
            categoryvalue.setCategoryName(categoryEntity.getCategoryName());
            categoryvalue.setCategoryId(categoryEntity.getCategoryId());
            categoryvalue.setItemEntityList(categoryEntity.getItemEntityList());
            categoryRepository.save(categoryvalue);
            return modelMapper.map(categoryEntity,CategoryResponse.class);
        });


    }

    @Override
    public Optional<ItemResponse> updateItem(Integer id, ItemModel itemDetails) throws Exception {

        ModelMapper modelMapper=new ModelMapper();
        ItemEntity itemEntity=modelMapper.map(itemDetails, ItemEntity.class);
        if(itemDetails.getCategory()!=null) {
            return itemRepository.findById(id).map(itemvalue -> {
                itemvalue.setItemName(itemEntity.getItemName());
                itemvalue.setItemPrice(itemEntity.getItemPrice());
                itemvalue.setCategory(itemEntity.getCategory());
                itemRepository.save(itemvalue);
                return modelMapper.map(itemEntity, ItemResponse.class);
            });
        }
        return itemRepository.findById(id).map(itemvalue -> {
            itemvalue.setItemName(itemDetails.getItemName());
            itemvalue.setItemPrice(itemDetails.getItemPrice());
            itemRepository.save(itemvalue);
            return modelMapper.map(itemEntity, ItemResponse.class);
        });
    }
}