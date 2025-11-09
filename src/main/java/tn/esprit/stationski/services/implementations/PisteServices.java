package tn.esprit.stationski.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Piste;
import tn.esprit.stationski.repositories.PisteRepository;
import tn.esprit.stationski.services.interfaces.IPisteInterface;

import java.util.List;

@Service
public class PisteServices implements IPisteInterface {
    private final PisteRepository pisteRepository;

    public PisteServices(PisteRepository pisteRepository) {
        this.pisteRepository = pisteRepository;
    }

    @Override
    public List<Piste> retriveAll() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste retrievePist(Long numPiste) {
        return pisteRepository.findById(numPiste).orElseThrow();
    }

    @Override
    public void deletePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }
}
