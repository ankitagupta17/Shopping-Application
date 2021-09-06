package com.cart;


import com.cart.Model.CategoryModel;
import com.cart.controller.ItemController;
import com.cart.entity.CategoryEntity;
import com.cart.service.ItemService;
import com.cart.service.serviceImpl.ItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
public class STest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ItemServiceImpl itemService;

    @MockBean
    ItemController itemController;

    @Test
    void test_add_API() {
        CategoryEntity categoryEntityStub = new CategoryEntity("Furniture");
        when(itemService.addCategory(any(CategoryModel.class))).thenReturn("hello");

        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/addCategory")
                    .contentType(MediaType.APPLICATION_JSON).content("{    \"categoryNme\":\"Furniture\" }")).andReturn();
            int status = result.getResponse().getStatus();
            System.out.println(status);
            assertEquals(200, status);
            System.out.println(result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Test
    void test_addcontroller_API() {
        CategoryEntity categoryEntityStub = new CategoryEntity("Furniture");
        when(itemController.addCategory(any(CategoryModel.class),any(BindingResult.class))).thenReturn(new ResponseEntity<String>("Shivam added", HttpStatus.OK));

        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/addCategory")
                    .contentType(MediaType.APPLICATION_JSON).content("{    \"categoryName\":\"Furniture\" }")).andReturn();
            int status = result.getResponse().getStatus();
            System.out.println(status);
            assertEquals(200, status);
            System.out.println(result.getResponse().getContentAsString());
            assertEquals("Shivam adde",result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


