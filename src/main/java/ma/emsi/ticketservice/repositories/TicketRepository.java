package ma.emsi.ticketservice.repositories;

import ma.emsi.ticketservice.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
