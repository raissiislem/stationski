package tn.esprit.stationski.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Abonnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numAbo;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Float prixAbo;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbo;
}