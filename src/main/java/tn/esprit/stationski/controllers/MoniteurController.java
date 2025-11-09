package tn.esprit.stationski.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Moniteur;
import tn.esprit.stationski.services.interfaces.IMoniteurInterface;

import java.util.List;

@RestController
@RequestMapping("/api/moniteur")
public class MoniteurController {

    private final IMoniteurInterface moniteurService;

    public MoniteurController(IMoniteurInterface moniteurService) {
        this.moniteurService = moniteurService;
    }

    @PostMapping("/add")
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.addMoniteur(moniteur);
    }

    @PutMapping("/update")
    public Moniteur updateMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.updateMoniteur(moniteur);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMoniteur(@PathVariable Long id) {
        moniteurService.deleteMoniteur(id);
    }

    @GetMapping("/all")
    public List<Moniteur> getAllMoniteurs() {
        return moniteurService.retriveAll();
    }

    @GetMapping("/{id}")
    public Moniteur getMoniteur(@PathVariable Long id) {
        return moniteurService.retrieveMoniteur(id);
    }
}
