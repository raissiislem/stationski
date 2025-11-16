package tn.esprit.stationski.services.interfaces;

import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.entities.TypeAbonnement;

import java.util.List;

public interface ISkieurInterface {

    public List<Skieur> retriveAll();
    public Skieur addSkieur(Skieur skieur);
    public Skieur updateSkieur(Skieur skieur);
    public Skieur retrieveSkieur(Long numSkieur);
    public void deleteSkieur(Long numSkieur);
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
    public Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse);
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
    }
