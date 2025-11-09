package tn.esprit.stationski.services.interfaces;

import tn.esprit.stationski.entities.Piste;

import java.util.List;

public interface IPisteInterface {

    public List<Piste> retriveAll();
    public Piste addPiste(Piste piste);
    public Piste updatePiste(Piste piste);
    public Piste retrievePist(Long numPiste);
    public void deletePiste(Long numPiste);
}
