package com.grocery.booking.exception;

import java.lang.reflect.Executable;

public class UserFoundNotExecption extends RuntimeException{

    public UserFoundNotExecption(String ex){
        super(ex);
    }
}
