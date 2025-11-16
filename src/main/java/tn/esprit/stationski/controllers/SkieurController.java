package tn.esprit.stationski.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.entities.TypeAbonnement;
import tn.esprit.stationski.services.interfaces.ISkieurInterface;

import java.util.List;

@RestController
@RequestMapping("/api/skiers")
public class SkieurController {

    private final ISkieurInterface skieurService;

    public SkieurController(ISkieurInterface skieurService) {
        this.skieurService = skieurService;
    }

    @GetMapping("/all")
    public List<Skieur> getAllSkiers() {
        return skieurService.retriveAll();
    }

    @PostMapping("/add")
    public Skieur addSkieur(@RequestBody Skieur skieur) {
        return skieurService.addSkieur(skieur);
    }

    @PutMapping("/update")
    public Skieur updateSkieur(@RequestBody Skieur skieur) {
        return skieurService.updateSkieur(skieur);
    }

    @GetMapping("/{id}")
    public Skieur getSkieur(@PathVariable Long id) {
        return skieurService.retrieveSkieur(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSkieur(@PathVariable Long id) {
        skieurService.deleteSkieur(id);
    }

    @PostMapping("/assign-piste/{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable Long numSkieur,
                                     @PathVariable Long numPiste) {
        return skieurService.assignSkierToPiste(numSkieur, numPiste);
    }

    @PostMapping("/add-course/{numCourse}")
    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur skier,
                                            @PathVariable Long numCourse) {
        return skieurService.addSkierAndAssignToCourse(skier, numCourse);
    }

    @GetMapping("/by-subscription")
    public List<Skieur> getSkiersBySubscriptionType(@RequestParam TypeAbonnement type) {
        return skieurService.retrieveSkiersBySubscriptionType(type);
    }
}
