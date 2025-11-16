package tn.esprit.stationski.services.interfaces;

import tn.esprit.stationski.entities.Moniteur;
import tn.esprit.stationski.entities.Support;

import java.util.List;

public interface IMoniteurInterface {

    public List<Moniteur> retriveAll();
    public Moniteur addMoniteur(Moniteur moniteur);
    public Moniteur updateMoniteur(Moniteur moniteur);
    public Moniteur retrieveMoniteur(Long numMoniteur);
    public void deleteMoniteur(Long numMoniteur);
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);
    }
