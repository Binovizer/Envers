package com.binovizer.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The type PagedTicketResponse
 *
 * @author Mohd Nadeem
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagedTicketResponse {

    @JsonProperty("page_count")
    private Integer pageCount;

    @JsonProperty("total_count")
    private Long totalCount;

    @JsonProperty("page_number")
    private Integer pageNumber;

    @JsonProperty("tickets")
    private List<TicketResponse> tickets;

}
