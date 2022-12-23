package ma.emsi.ticketservice.mappers;

import ma.emsi.ticketservice.dtos.responses.MatchResponseDto;
import ma.emsi.ticketservice.dtos.responses.TicketResponseDto;
import ma.emsi.ticketservice.entities.Match;
import ma.emsi.ticketservice.entities.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    public MatchResponseDto fromMatch(Match math){
        MatchResponseDto matchResponseDto = new MatchResponseDto();
        BeanUtils.copyProperties(math, matchResponseDto);
        return  matchResponseDto;
    }

    public TicketResponseDto fromTicket(Ticket ticket){
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        BeanUtils.copyProperties(ticket, ticketResponseDto);
        ticketResponseDto.setMatchResponseDto(fromMatch(ticket.getMatch()));
        return ticketResponseDto;
    }

}
