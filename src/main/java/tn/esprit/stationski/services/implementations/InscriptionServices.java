package tn.esprit.stationski.services.implementations;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.*;
import tn.esprit.stationski.repositories.CoursRepository;
import tn.esprit.stationski.repositories.InscriptionRepository;
import tn.esprit.stationski.repositories.MoniteurRepository;
import tn.esprit.stationski.repositories.SkieurRepository;
import tn.esprit.stationski.services.interfaces.IInscriptionInterface;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class InscriptionServices implements IInscriptionInterface {
    private final InscriptionRepository inscriptionRepository;
    private final SkieurRepository skieurRepository;
    private final CoursRepository coursRepository;

    public InscriptionServices(InscriptionRepository inscriptionRepository, SkieurRepository skieurRepository, CoursRepository coursRepository) {
        this.inscriptionRepository = inscriptionRepository;
        this.skieurRepository = skieurRepository;
        this.coursRepository = coursRepository;
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
    public Inscription addRegistrationAndAssignToSkierAndCourse(
            Inscription inscription,
            Long numSkieur,
            Long numCours) {

        Skieur skieur = skieurRepository.findById(numSkieur).orElseThrow();

        Cours cours = coursRepository.findById(numCours).orElseThrow();

        if (cours.getTypeCours() == TypeCourse.COLLECTIF_ENFANT ||
                cours.getTypeCours() == TypeCourse.COLLECTIF_ADULTE) {

            if (cours.getInscriptions() != null && cours.getInscriptions().size() >= 6) {
                throw new RuntimeException("Cannot register: Course already has 6 skiers.");
            }
        }

        int age = Period.between(skieur.getDateNaissance(), LocalDate.now()).getYears();

        if (cours.getTypeCours() == TypeCourse.COLLECTIF_ENFANT && age > 12) {
            throw new RuntimeException("Skieur too old for COLLECTIF_ENFANT course.");
        }

        if (cours.getTypeCours() == TypeCourse.COLLECTIF_ADULTE && age <= 12) {
            throw new RuntimeException("Skieur too young for COLLECTIF_ADULTE course.");
        }

        inscription.setSkieur(skieur);
        inscription.setCours(cours);

        if (skieur.getInscriptions() == null)
            skieur.setInscriptions(new ArrayList<>());
        skieur.getInscriptions().add(inscription);

        if (cours.getInscriptions() == null)
            cours.setInscriptions(new ArrayList<>());
        cours.getInscriptions().add(inscription);

        return inscriptionRepository.save(inscription);
    }
}
