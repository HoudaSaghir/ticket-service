package ma.emsi.ticketservice.services.Ticket;

import ma.emsi.ticketservice.dtos.requests.TicketRequestDto;
import ma.emsi.ticketservice.dtos.responses.TicketResponseDto;

public interface TicketService {
    TicketResponseDto buyTicket(TicketRequestDto ticketInputDto);

    void validateTicket(Long id);
}
