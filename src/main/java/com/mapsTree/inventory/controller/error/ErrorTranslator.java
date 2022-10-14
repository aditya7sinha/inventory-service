package com.mapsTree.inventory.controller.error;

import com.mapsTree.inventory.model.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorTranslator {
    @ExceptionHandler(ErrorResponse.class)
    public ResponseEntity<Error> handleBaseException(ErrorResponse ex)
    {
        Error error = new Error()
                .code(ex.getCode())
                .reason(ex.getReason())
                .status(String.format("%d",ex.getStatus()))
                .message(ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(error);
    }
}
