package com.binovizer.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * The type CreateTicketRequest
 *
 * @author Mohd Nadeem
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateTicketRequest {

    @JsonProperty("appointment_id")
    private String appointmentId;

    @JsonProperty("time_slot")
    private TimeSlot timeSlot;

    private String description;

    @NotNull(message = "'updated_by' can not be empty")
    @JsonProperty("updated_by")
    private String updatedBy;

}
