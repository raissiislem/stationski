package tn.esprit.stationski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stationski.entities.Moniteur;

@Repository
public interface MoniteurRepository extends JpaRepository<Moniteur, Long> {
}
