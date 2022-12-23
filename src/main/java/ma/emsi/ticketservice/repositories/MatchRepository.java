package ma.emsi.ticketservice.repositories;

import ma.emsi.ticketservice.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match,Long> {
}
