package com.binovizer.dto.request;

import com.binovizer.exception.ErrorCode;
import com.binovizer.exception.ValidationException;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * The type TimeSlot
 *
 * @author Mohd Nadeem
 */
@Getter
@RequiredArgsConstructor
public enum TimeSlot {

    FIRST_HALF("10 AM - 1 PM", 10),
    SECOND_HALF("2 PM - 5 PM", 20);

    @JsonValue
    private final String value;
    private final Integer code;

    public static TimeSlot forCode(Integer code) {
        return Arrays.stream(TimeSlot.values())
                .filter(timeSlot -> timeSlot.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new ValidationException(ErrorCode.INVALID_TIME_SLOT_CODE));
    }

}
