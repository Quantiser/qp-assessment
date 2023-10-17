package com.grocery.booking.exception;

import com.grocery.booking.model.ErorrMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestEntityExceptionhandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErorrMessage generalExceptionHandler(Exception exception){
        return new ErorrMessage(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErorrMessage userNotFoundHandler(UserFoundNotExecption exception){
        return new ErorrMessage(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErorrMessage ItemNotFoundHandler(ItemNotFoundException exception){
        return new ErorrMessage(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErorrMessage quantityNotEnough(NotEnoughQuantityException exception){
        return new ErorrMessage(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
    }
}
