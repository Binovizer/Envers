package com.binovizer.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The type TicketServiceException
 *
 * @author Mohd Nadeem
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TicketServiceException extends RuntimeException {

    private ErrorCode errorCode;

    public TicketServiceException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "TicketServiceException{" +
                "message=" + super.getMessage() +
                "errorCode=" + errorCode +
                '}';
    }
}
