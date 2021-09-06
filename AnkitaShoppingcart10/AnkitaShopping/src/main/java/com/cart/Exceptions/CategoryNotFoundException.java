package com.cart.Exceptions;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message)
    {
        super(message);
    }
}
