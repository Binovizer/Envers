package com.binovizer.service.impl;

import com.binovizer.db.entity.Ticket;
import com.binovizer.db.repo.TicketRepository;
import com.binovizer.dto.request.CreateTicketRequest;
import com.binovizer.dto.request.TimeSlot;
import com.binovizer.dto.request.UpdateTicketRequest;
import com.binovizer.dto.response.PagedTicketResponse;
import com.binovizer.dto.response.TicketDetail;
import com.binovizer.dto.response.TicketResponse;
import com.binovizer.exception.ErrorCode;
import com.binovizer.exception.TicketServiceException;
import com.binovizer.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type TicketServiceImpl
 *
 * @author Mohd Nadeem
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public TicketResponse createTicket(CreateTicketRequest createTicketRequest) {
        Ticket ticket = Ticket.buildFrom(createTicketRequest);
        Ticket dbTicket = ticketRepository.save(ticket);
        return TicketResponse.buildFrom(dbTicket);
    }

    @Override
    public TicketDetail getTicketDetail(Long ticketId) {
        Optional<Ticket> ticketMaybe = ticketRepository.findById(ticketId);
        Ticket dbTicket = ticketMaybe.orElseThrow(() -> new TicketServiceException(ErrorCode.TICKET_NOT_FOUND));
        return TicketDetail.buildFrom(dbTicket);
    }

    @Override
    public TicketResponse updateTicket(Long ticketId, UpdateTicketRequest updateTicketRequest) {
        Optional<Ticket> ticketMaybe = ticketRepository.findById(ticketId);
        Ticket dbTicket = ticketMaybe.orElseThrow(() -> new TicketServiceException(ErrorCode.TICKET_NOT_FOUND));
        String appointmentId = updateTicketRequest.getAppointmentId();
        if(Objects.nonNull(appointmentId)){
            dbTicket.setAppointmentId(appointmentId);
        }
        String updatedBy = updateTicketRequest.getUpdatedBy();
        if(Objects.nonNull(updatedBy)){
            dbTicket.setUpdatedBy(updatedBy);
        }
        String description = updateTicketRequest.getDescription();
        if(Objects.nonNull(description)){
            dbTicket.setDescription(description);
        }
        TimeSlot timeSlot = updateTicketRequest.getTimeSlot();
        if(Objects.nonNull(timeSlot)){
            dbTicket.setTimeSlot(timeSlot);
        }
        Ticket updatedTicket = ticketRepository.save(dbTicket);
        return TicketResponse.buildFrom(updatedTicket);
    }

    @Override
    public PagedTicketResponse getAllTickets(Integer pageNumber) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, 10);
        Page<Ticket> ticketPage = ticketRepository.findAll(pageRequest);
        List<Ticket> allDbTickets = ticketPage.getContent();
        List<TicketResponse> tickets =
                allDbTickets.stream().map(TicketResponse::buildFrom).collect(Collectors.toList());
        return PagedTicketResponse.builder()
                .totalCount(ticketPage.getTotalElements())
                .pageCount(ticketPage.getNumberOfElements())
                .pageNumber(ticketPage.getNumber() + 1)
                .tickets(tickets)
                .build();
    }

}
