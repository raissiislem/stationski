package tn.esprit.stationski.services.interfaces;

import tn.esprit.stationski.entities.Inscription;

public interface IInscriptionInterface {

    Inscription addRegistrationAndAssignToSkier(Inscription inscription, Long numSkier);
    Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse);
    Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours);



    }
