package tn.esprit.stationski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stationski.entities.Cours;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
}
