package tn.esprit.stationski.services.interfaces;

import tn.esprit.stationski.entities.Abonnement;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IAbonnementInterface {
    Set<Abonnement> getSubscriptionByType(TypeAbonnement type);
    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);


    }
