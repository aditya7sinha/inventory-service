package com.mapsTree.inventory.controller.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse extends RuntimeException {

    private final String code;
    private final String reason;
    private final Integer status;
    private final String message;


    public ErrorResponse(String code, String reason, Integer status, String message) {
        this.code = code;
        this.reason = reason;
        this.status = status;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }

    public Integer getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "code='" + code + '\'' +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}

