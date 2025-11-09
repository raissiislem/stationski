package tn.esprit.stationski.services.interfaces;

import tn.esprit.stationski.entities.Cours;

import java.util.List;

public interface ICoursInterface {

    public List<Cours> retriveAll();
    public Cours addCours(Cours cours);
    public Cours updateCours(Cours cours);
    public Cours retrieveCours(Long numCours);
    public void deleteCours(Long numCours);
}
