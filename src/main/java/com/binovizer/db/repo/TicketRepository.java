package com.binovizer.db.repo;

import com.binovizer.db.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The type TicketRepository
 *
 * @author Mohd Nadeem
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
