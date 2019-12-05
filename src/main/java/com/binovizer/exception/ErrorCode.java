package com.binovizer.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The type ErrorCodes
 *
 * @author Mohd Nadeem
 */
@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "Some error occured. Please try again later."),
    DATABASE_BAD_REQUEST("INVALID_REQUEST", "Data Already Exists. Constraints Violated"),
    INVALID_DATA("INVALID_DATA", "Invalid input parameters."),

    INVALID_TIME_SLOT_CODE("INVALID_TIME_SLOT_CODE", "Invalid time slot code."),
    TICKET_NOT_FOUND("TICKET_NOT_FOUND", "Ticket not found.");

    private final String code;
    private final String message;

}
