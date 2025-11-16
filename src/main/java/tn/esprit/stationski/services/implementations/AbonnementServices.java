package tn.esprit.stationski.services.implementations;

import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Abonnement;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.TypeAbonnement;
import tn.esprit.stationski.repositories.AbonnementRepository;
import tn.esprit.stationski.repositories.CoursRepository;
import tn.esprit.stationski.services.interfaces.IAbonnementInterface;
import tn.esprit.stationski.services.interfaces.ICoursInterface;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class AbonnementServices implements IAbonnementInterface {
    private AbonnementRepository abonnementRepository;

    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        return abonnementRepository.findByTypeAboOrderByDateDebut(type);
    }
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return abonnementRepository.findByDateDebutBetween(startDate, endDate);
    }
}
