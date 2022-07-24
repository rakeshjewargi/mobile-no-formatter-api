package com.link.mobility.apis.exception;

import com.link.mobility.apis.models.APIError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
                                                                        BindingResult bindingResult){
        APIError apiError=new APIError();
        for(FieldError fieldError: bindingResult.getFieldErrors()){
            apiError=new APIError("10002", fieldError.getDefaultMessage(), new Date());
        }
        return new ResponseEntity(apiError, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e){
        APIError apiError=new APIError("10001",e.getMessage(),new Date());
        return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
