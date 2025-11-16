package tn.esprit.stationski.services.implementations;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.Inscription;
import tn.esprit.stationski.entities.Moniteur;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.repositories.CoursRepository;
import tn.esprit.stationski.repositories.InscriptionRepository;
import tn.esprit.stationski.repositories.MoniteurRepository;
import tn.esprit.stationski.repositories.SkieurRepository;
import tn.esprit.stationski.services.interfaces.IInscriptionInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class InscriptionServices implements IInscriptionInterface {
    private final InscriptionRepository inscriptionRepository;
    private final SkieurRepository skieurRepository;
    private final CoursRepository coursRepository;

    public InscriptionServices(InscriptionRepository inscriptionRepository, SkieurRepository skieurRepository) {
        this.inscriptionRepository = inscriptionRepository;
        this.skieurRepository = skieurRepository;
    }

    public Inscription addRegistrationAndAssignToSkier(Inscription inscription, Long numSkier) {

        Skieur skieur = skieurRepository.findById(numSkier).orElseThrow();

        inscription.setSkieur(skieur);

        if (skieur.getInscriptions() == null) {
            skieur.setInscriptions(new ArrayList<>());
        }
        skieur.getInscriptions().add(inscription);

        return inscriptionRepository.save(inscription);
    }

    public Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Inscription inscription = inscriptionRepository.findById(numRegistration).orElseThrow();
        Cours cours = coursRepository.findById(numCourse).orElseThrow();
        inscription.setCours(cours);

        if (cours.getInscriptions() == null) {
            cours.setInscriptions(new ArrayList<>());
        }
        if (!cours.getInscriptions().contains(inscription)) {
            cours.getInscriptions().add(inscription);
        }

        return inscriptionRepository.save(inscription);
    }
}
