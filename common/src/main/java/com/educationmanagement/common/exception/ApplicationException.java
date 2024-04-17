package com.educationmanagement.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ApplicationException extends RuntimeException{
    private final HttpStatus httpStatus;

    private final String message;
    private final String errorDetails;
    private final String status;
    private final String errorCode;
}
