package tn.esprit.stationski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stationski.entities.Piste;

@Repository
public interface PisteRepository extends JpaRepository<Piste, Long> {
}
