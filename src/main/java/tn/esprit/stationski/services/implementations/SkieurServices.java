package tn.esprit.stationski.services.implementations;

import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.*;
import tn.esprit.stationski.repositories.CoursRepository;
import tn.esprit.stationski.repositories.InscriptionRepository;
import tn.esprit.stationski.repositories.PisteRepository;
import tn.esprit.stationski.repositories.SkieurRepository;
import tn.esprit.stationski.services.interfaces.ISkieurInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkieurServices implements ISkieurInterface {
    private final SkieurRepository skieurRepository;
    private final PisteRepository pisteRepository;
    private final CoursRepository coursRepository;
    private final InscriptionRepository inscriptionRepository;

    public SkieurServices(SkieurRepository skieurRepository, PisteRepository pisteRepository, CoursRepository coursRepository, InscriptionRepository inscriptionRepository) {
        this.skieurRepository = skieurRepository;
        this.pisteRepository = pisteRepository;
        this.coursRepository = coursRepository;
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public List<Skieur> retriveAll() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur).orElseThrow();
    }

    @Override
    public void deleteSkieur(Long numSkieur) {
        skieurRepository.deleteById(numSkieur);
    }

    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElseThrow();

        Piste piste = pisteRepository.findById(numPiste).orElseThrow();

        if (skieur.getPistes() == null) skieur.setPistes(new ArrayList<>());
        if (piste.getSkieurs() == null) piste.setSkieurs(new ArrayList<>());

        if (!skieur.getPistes().contains(piste)) skieur.getPistes().add(piste);
        if (!piste.getSkieurs().contains(skieur)) piste.getSkieurs().add(skieur);

        return skieurRepository.save(skieur);
    }

    public Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse) {

        Cours cours = coursRepository.findById(numCourse).orElseThrow();

        if (skier.getAbonnement() == null) {
            throw new RuntimeException("Skieur must contain an Abonnement object.");
        }

        Skieur savedSkieur = skieurRepository.save(skier);

        Inscription inscription = new Inscription();
        inscription.setSkieur(savedSkieur);
        inscription.setCours(cours);
        inscription.setNumSemaine(0);

        if (savedSkieur.getInscriptions() == null)
            savedSkieur.setInscriptions(new ArrayList<>());
        savedSkieur.getInscriptions().add(inscription);

        if (cours.getInscriptions() == null)
            cours.setInscriptions(new ArrayList<>());
        cours.getInscriptions().add(inscription);

        inscriptionRepository.save(inscription);

        return skieurRepository.save(savedSkieur);
    }

    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepository.findByAbonnement_TypeAbo(typeAbonnement);
    }
}
