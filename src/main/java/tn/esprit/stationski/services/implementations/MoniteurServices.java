package tn.esprit.stationski.services.implementations;

import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.Inscription;
import tn.esprit.stationski.entities.Moniteur;
import tn.esprit.stationski.entities.Support;
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
        Cours cours = coursRepository.findById(numCourse).orElseThrow();

        if (moniteur.getCours() == null) {
            moniteur.setCours(new ArrayList<>());
        }

        moniteur.getCours().add(cours);

        return moniteurRepository.save(moniteur);
    }
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        Moniteur moniteur = moniteurRepository.findById(numInstructor).orElseThrow();
        List<Integer> weeks = new ArrayList<>();

        if (moniteur.getCours() != null) {
            for (Cours cours : moniteur.getCours()) {
                if (cours.getSupport() == support && cours.getInscriptions() != null) {
                    for (Inscription insc : cours.getInscriptions()) {
                        weeks.add(insc.getNumSemaine());
                    }
                }
            }
        }

        return weeks.stream().distinct().sorted().toList();
    }


}
