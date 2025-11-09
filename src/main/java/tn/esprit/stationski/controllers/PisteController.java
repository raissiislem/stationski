package tn.esprit.stationski.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Piste;
import tn.esprit.stationski.services.interfaces.IPisteInterface;

import java.util.List;

@RestController
@RequestMapping("/api/piste")
public class PisteController {

    private final IPisteInterface pisteService;

    public PisteController(IPisteInterface pisteService) {
        this.pisteService = pisteService;
    }

    @PostMapping("/add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }

    @PutMapping("/update")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteService.updatePiste(piste);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePiste(@PathVariable Long id) {
        pisteService.deletePiste(id);
    }

    @GetMapping("/all")
    public List<Piste> getAllPistes() {
        return pisteService.retriveAll();
    }

    @GetMapping("/{id}")
    public Piste getPiste(@PathVariable Long id) {
        return pisteService.retrievePist(id);
    }
}
