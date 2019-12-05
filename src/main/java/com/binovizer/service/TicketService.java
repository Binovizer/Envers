package com.binovizer.service;

import com.binovizer.dto.request.CreateTicketRequest;
import com.binovizer.dto.request.UpdateTicketRequest;
import com.binovizer.dto.response.PagedTicketResponse;
import com.binovizer.dto.response.TicketResponse;
import com.binovizer.dto.response.TicketDetail;

import java.util.List;

/**
 * The type TicketService
 *
 * @author Mohd Nadeem
 */
public interface TicketService {

    TicketResponse createTicket(CreateTicketRequest createTicketRequest);

    TicketDetail getTicketDetail(Long ticketId);

    TicketResponse updateTicket(Long ticketId, UpdateTicketRequest updateTicketRequest);

    PagedTicketResponse getAllTickets(Integer pageNumber);

}
