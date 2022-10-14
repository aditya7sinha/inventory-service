package com.mapsTree.inventory.controller.error;

public class NotFoundException extends ErrorResponse{
    public NotFoundException(String code, String reason, String message) {
        super(code, reason, 404, message);
    }
}
