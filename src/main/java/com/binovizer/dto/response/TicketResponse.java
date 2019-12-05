package com.binovizer.dto.response;

import com.binovizer.db.entity.Ticket;
import com.binovizer.dto.request.TimeSlot;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * The type CreateTicketResponse
 *
 * @author Mohd Nadeem
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"ticket_id"})
public class TicketResponse {

    @JsonProperty("ticket_id")
    private Long ticketId;

    @JsonProperty("appointment_id")
    private String appointmentId;

    @JsonProperty("time_slot")
    private TimeSlot timeSlot;

    private String description;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("created_at")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonProperty("updated_by")
    private String updatedBy;

    @JsonProperty("updated_at")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime updatedAt;

    public static TicketResponse buildFrom(Ticket ticket) {
        return TicketResponse.builder()
                .ticketId(ticket.getId())
                .appointmentId(ticket.getAppointmentId())
                .description(ticket.getDescription())
                .timeSlot(ticket.getTimeSlot())
                .createdBy(ticket.getCreatedBy())
                .createdAt(ticket.getCreatedAt())
                .updatedBy(ticket.getUpdatedBy())
                .updatedAt(ticket.getUpdatedAt())
                .build();
    }

}
