package com.grocery.booking.exception;

import java.lang.reflect.Executable;

public class NotEnoughQuantityException extends RuntimeException{

    public NotEnoughQuantityException(String e){
        super(e);
    }

}
