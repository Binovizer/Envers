package com.binovizer.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type CreateTicketRequest
 *
 * @author Mohd Nadeem
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTicketRequest {

    @JsonProperty("appointment_id")
    private String appointmentId;

    @JsonProperty("time_slot")
    private TimeSlot timeSlot;

    private String description;

    private String createdBy;

}
