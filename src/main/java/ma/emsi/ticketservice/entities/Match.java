package ma.emsi.ticketservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(unique = true , nullable = false)
        private String ref;
        private String lieux;
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        private Date date;
        private String equipe1;
        private String equipe2;
        private Integer NombreTickets;
        @OneToMany(mappedBy = "match")
        private List<Ticket> tickets;

}
