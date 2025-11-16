package tn.esprit.stationski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stationski.entities.Abonnement;
import tn.esprit.stationski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
    List<Abonnement> findByTypeAboOrderByDateDebut(TypeAbonnement typeAbonnement);
    List<Abonnement> findByDateDebutBetween(LocalDate startDate, LocalDate endDate);
}
