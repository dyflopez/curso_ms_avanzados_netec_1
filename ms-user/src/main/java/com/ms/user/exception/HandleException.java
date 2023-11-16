package com.ms.user.exception;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
 @AllArgsConstructor
public class HandleException {

    @ExceptionHandler(MyHandleException.class)
    public ResponseEntity<Object>  manejadorPropioException(MyHandleException ex){

        log.error("error persolizado " + ex.getMessage() , HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(
                "error persolizado " + ex.getMessage() , HttpStatus.BAD_REQUEST
        );
    }

}
