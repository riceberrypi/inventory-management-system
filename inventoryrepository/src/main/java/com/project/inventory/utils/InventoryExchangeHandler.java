package com.project.inventory.utils;

import com.project.inventory.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@Controller
@RestController
public class InventoryExchangeHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleInternalServerError(Exception ex){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundError(NoSuchElementException ex){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }


}
