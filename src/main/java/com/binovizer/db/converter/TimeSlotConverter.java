package com.binovizer.db.converter;

import com.binovizer.dto.request.TimeSlot;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * The type TimeSlotConverter
 *
 * @author Mohd Nadeem
 */
@Converter(autoApply = true)
public class TimeSlotConverter implements AttributeConverter<TimeSlot, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TimeSlot timeSlot) {
        return timeSlot.getCode();
    }

    @Override
    public TimeSlot convertToEntityAttribute(Integer code) {
        return TimeSlot.forCode(code);
    }
}
