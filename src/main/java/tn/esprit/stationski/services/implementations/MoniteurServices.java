package tn.esprit.stationski.services.implementations;

import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.Moniteur;
import tn.esprit.stationski.repositories.CoursRepository;
import tn.esprit.stationski.repositories.MoniteurRepository;
import tn.esprit.stationski.services.interfaces.IMoniteurInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoniteurServices implements IMoniteurInterface {
    private final MoniteurRepository moniteurRepository;
    private final CoursRepository coursRepository;

    public MoniteurServices(MoniteurRepository moniteurRepository, CoursRepository coursRepository) {
        this.moniteurRepository = moniteurRepository;
        this.coursRepository = coursRepository;
    }

    @Override
    public List<Moniteur> retriveAll() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepository.findById(numMoniteur).orElseThrow();
    }

    @Override
    public void deleteMoniteur(Long numMoniteur) {
        moniteurRepository.deleteById(numMoniteur);
    }
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        // 1. Retrieve the course
        Cours cours = coursRepository.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + numCourse));

        // 2. Initialize Moniteur's course list if null
        if (moniteur.getCours() == null) {
            moniteur.setCours(new ArrayList<>());
        }

        // 3. Assign the course to the moniteur
        moniteur.getCours().add(cours);


        return moniteurRepository.save(moniteur);
    }
}
