package tn.esprit.stationski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stationski.entities.Skieur;

@Repository
public interface SkieurRepository extends JpaRepository<Skieur, Long> {
}
