package tn.esprit.stationski.services.implementations;

import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.Piste;
import tn.esprit.stationski.repositories.CoursRepository;
import tn.esprit.stationski.repositories.PisteRepository;
import tn.esprit.stationski.services.interfaces.ICoursInterface;
import tn.esprit.stationski.services.interfaces.IPisteInterface;

import java.util.List;

@Service
public class CoursServices implements ICoursInterface {
    private CoursRepository coursRepository;

    @Override
    public List<Cours> retriveAll() {
       return coursRepository.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours retrieveCours(Long numCours) {
        return coursRepository.findById(numCours).orElseThrow();
    }

    @Override
    public void deleteCours(Long numCours) {
        coursRepository.deleteById(numCours);
    }
}
