package tn.esprit.stationski.services.interfaces;

import tn.esprit.stationski.entities.Skieur;

import java.util.List;

public interface ISkieurInterface {

    public List<Skieur> retriveAll();
    public Skieur addSkieur(Skieur skieur);
    public Skieur updateSkieur(Skieur skieur);
    public Skieur retrieveSkieur(Long numSkieur);
    public void deleteSkieur(Long numSkieur);
}
