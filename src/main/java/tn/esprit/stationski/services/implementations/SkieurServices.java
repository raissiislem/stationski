package tn.esprit.stationski.services.implementations;

import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.repositories.SkieurRepository;
import tn.esprit.stationski.services.interfaces.ISkieurInterface;

import java.util.List;

@Service
public class SkieurServices implements ISkieurInterface {
    private final SkieurRepository skieurRepository;

    public SkieurServices(SkieurRepository skieurRepository) {
        this.skieurRepository = skieurRepository;
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
}
