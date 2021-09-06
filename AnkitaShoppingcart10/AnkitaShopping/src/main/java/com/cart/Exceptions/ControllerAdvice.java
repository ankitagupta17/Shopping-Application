package com.cart.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.ControllerAdvice
@RestController
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<Object> handleException(
            GenericException ex, WebRequest request)
    {
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("message",ex.getMessage());
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }
}
