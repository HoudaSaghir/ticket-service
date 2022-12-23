package ma.emsi.ticketservice.services.Ticket;

import lombok.AllArgsConstructor;
import ma.emsi.ticketservice.Enums.Statut;
import ma.emsi.ticketservice.dtos.requests.TicketRequestDto;
import ma.emsi.ticketservice.dtos.responses.TicketResponseDto;
import ma.emsi.ticketservice.entities.Match;
import ma.emsi.ticketservice.entities.Ticket;
import ma.emsi.ticketservice.mappers.MapperService;
import ma.emsi.ticketservice.repositories.MatchRepository;
import ma.emsi.ticketservice.repositories.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private MapperService mapperService;
    private MatchRepository matchRepository;
    private TicketRepository ticketRepository;

    @Override
    public TicketResponseDto buyTicket(TicketRequestDto ticketInputDto){
        if (ticketInputDto.getMatchId() == null||
        ticketInputDto.getPrice().isNaN() || ticketInputDto.getPrice() <= 0)
        throw new RuntimeException("Field missing");
        Match match = matchRepository.findById(ticketInputDto.getMatchId())
                .orElseThrow(
                        () -> new RuntimeException("Id not found")
                );
        if (match.getNombreTickets() == 0)
            throw new RuntimeException("Ticket sold out");
        Ticket ticket = new Ticket();
        ticket.setPrice(ticketInputDto.getPrice());
        ticket.setStatut(Statut.ACTIVE);
        ticket.setRef(UUID.randomUUID().toString().substring(0,16));
        ticket.setMatch(match);

        match.setNombreTickets(match.getNombreTickets() - 1);
        matchRepository.save(match);
        return mapperService.fromTicket(ticketRepository.save(ticket));
    }

    @Override
    public void validateTicket(Long id){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id Not Found"));
        if (ticket.getStatut()== Statut.DESACTIVE)
            throw new RuntimeException("Ticket deja valider");
        ticket.setStatut(Statut.DESACTIVE);
        ticketRepository.save(ticket);
    }
}
