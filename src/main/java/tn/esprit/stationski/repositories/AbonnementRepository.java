package tn.esprit.stationski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stationski.entities.Abonnement;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
}
