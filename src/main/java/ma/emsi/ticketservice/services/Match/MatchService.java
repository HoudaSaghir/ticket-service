package ma.emsi.ticketservice.services.Match;

import ma.emsi.ticketservice.dtos.requests.MatchRequestDto;
import ma.emsi.ticketservice.dtos.responses.MatchResponseDto;

import java.util.List;

public interface MatchService {
    MatchResponseDto ajouterMatch(MatchRequestDto matchRequestDtos);

    List<MatchResponseDto> gamesList();
}
