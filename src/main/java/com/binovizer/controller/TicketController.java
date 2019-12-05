package com.binovizer.controller;

import com.binovizer.dto.request.CreateTicketRequest;
import com.binovizer.dto.request.UpdateTicketRequest;
import com.binovizer.dto.response.ApiResponse;
import com.binovizer.dto.response.PagedTicketResponse;
import com.binovizer.dto.response.TicketDetail;
import com.binovizer.dto.response.TicketResponse;
import com.binovizer.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * The type TicketController
 *
 * @author Mohd Nadeem
 */
@RestController
@RequestMapping("/v1/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)get
    public ApiResponse<?> createTicket(@RequestBody CreateTicketRequest createTicketRequest) {
        TicketResponse ticketResponse = ticketService.createTicket(createTicketRequest);
        return ApiResponse.success(ticketResponse);
    }

    @GetMapping("/{ticket_id}")
    public ApiResponse<?> getTicket(@PathVariable(name = "ticket_id") Long ticketId) {
        TicketDetail ticketDetail = ticketService.getTicketDetail(ticketId);
        return ApiResponse.success(ticketDetail);
    }

    @PutMapping("/{ticket_id}")
    public ApiResponse<?> updateTicket(@PathVariable(name = "ticket_id") Long ticketId,
                                       @Validated @RequestBody UpdateTicketRequest updateTicketRequest) {
        TicketResponse ticketResponse = ticketService.updateTicket(ticketId, updateTicketRequest);
        return ApiResponse.success(ticketResponse);
    }

    @GetMapping
    public ApiResponse<?> getAllTickets(@RequestParam(name = "page", required = false) Integer pageNumber) {
        if(Objects.isNull(pageNumber) || pageNumber < 1) {
            pageNumber = 1;
        }
        PagedTicketResponse pagedTicketResponse = ticketService.getAllTickets(pageNumber);
        return ApiResponse.success(pagedTicketResponse);
    }

}
