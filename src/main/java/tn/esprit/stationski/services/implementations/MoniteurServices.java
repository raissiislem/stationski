package tn.esprit.stationski.services.implementations;

import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Moniteur;
import tn.esprit.stationski.repositories.MoniteurRepository;
import tn.esprit.stationski.services.interfaces.IMoniteurInterface;

import java.util.List;

@Service
public class MoniteurServices implements IMoniteurInterface {
    private final MoniteurRepository moniteurRepository;

    public MoniteurServices(MoniteurRepository moniteurRepository) {
        this.moniteurRepository = moniteurRepository;
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
}
