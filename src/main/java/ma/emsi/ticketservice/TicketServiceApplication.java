package ma.emsi.ticketservice;

import ma.emsi.ticketservice.Enums.Statut;
import ma.emsi.ticketservice.entities.Match;
import ma.emsi.ticketservice.entities.Ticket;
import ma.emsi.ticketservice.repositories.MatchRepository;
import ma.emsi.ticketservice.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TicketServiceApplication  {


    public static void main(String[] args) {

        SpringApplication.run(TicketServiceApplication.class, args);
    }


}
