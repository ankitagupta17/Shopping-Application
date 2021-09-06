//package com.cart;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//
//public class ItemServiceException {
//
//    @Rule
//    public ExpectedException exception = ExpectedException.none();
//
//    @Test       //method used to check if category exists or not
//    public void quantity_zero() {
//        try {
//            Throwable exception = assertThrows(
//                    QuantityZeroException.class, () -> {
//                        Supermarket_Mainclass.readCustomerCarts("src\\test\\resources\\quantityzero.txt");
//                    }
//            );
//            assertEquals("There exists an item with quantity zero, Please enter correct value.", exception.getMessage());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}


