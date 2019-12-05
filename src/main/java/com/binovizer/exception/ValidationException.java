package com.binovizer.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The type ValidationException
 *
 * @author Mohd Nadeem
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ValidationException extends RuntimeException {

    private ErrorCode errorCode;

    public ValidationException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "ValidationException{" +
                "message=" + super.getMessage() +
                "errorCode=" + errorCode +
                '}';
    }
}
