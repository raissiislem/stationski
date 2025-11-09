package tn.esprit.stationski.services.interfaces;

import tn.esprit.stationski.entities.Moniteur;

import java.util.List;

public interface IMoniteurInterface {

    public List<Moniteur> retriveAll();
    public Moniteur addMoniteur(Moniteur moniteur);
    public Moniteur updateMoniteur(Moniteur moniteur);
    public Moniteur retrieveMoniteur(Long numMoniteur);
    public void deleteMoniteur(Long numMoniteur);
}
