package tn.esprit.stationski.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur;

    private String nomS;
    private String prenomS;

    private LocalDate dateNaissance;
    private String ville;

    @OneToMany(mappedBy = "skieur", cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Abonnement abonnement;
    @ManyToMany(mappedBy = "skieurs")
    private List<Piste> pistes;
}
