package com.grocery.booking.exception;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(String exception){
        super(exception);
    }
}
