package com.devstack.customerserviceapi.advisor;

import com.devstack.customerserviceapi.StandardResponseModel;
import com.devstack.pos.exception.EntryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWiderExceptionHandler {

    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponseModel> handleEntryNotFoundException(EntryNotFoundException e){
        return new ResponseEntity<StandardResponseModel>(
                new StandardResponseModel(404,e.getMessage(),e), HttpStatus.NOT_FOUND
        );
    }

}