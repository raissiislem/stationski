package tn.esprit.stationski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.entities.TypeAbonnement;

import java.util.List;

@Repository
public interface SkieurRepository extends JpaRepository<Skieur, Long> {
    List<Skieur> findByAbonnement_TypeAbo(TypeAbonnement typeAbonnement);
    Skieur findBById(long id);
}
