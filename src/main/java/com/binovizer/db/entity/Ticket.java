package com.binovizer.db.entity;

import com.binovizer.dto.request.CreateTicketRequest;
import com.binovizer.dto.request.TimeSlot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The type Ticket
 *
 * @author Mohd Nadeem
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "appointment_id")
    private String appointmentId;

    @Column(name = "time_slot")
    private TimeSlot timeSlot;

    @Column(name = "description")
    private String description;

    @Column(name = "created_by")
    private String createdBy;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public static Ticket buildFrom(CreateTicketRequest createTicketRequest) {
        return Ticket.builder()
                .appointmentId(createTicketRequest.getAppointmentId())
                .description(createTicketRequest.getDescription())
                .timeSlot(createTicketRequest.getTimeSlot())
                .createdBy(createTicketRequest.getCreatedBy())
                .build();
    }

}
