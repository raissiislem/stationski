package tn.esprit.stationski.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Moniteur;
import tn.esprit.stationski.entities.Support;
import tn.esprit.stationski.services.interfaces.IMoniteurInterface;

import java.util.List;

@RestController
@RequestMapping("/api/moniteurs")
public class MoniteurController {

    private final IMoniteurInterface moniteurService;

    public MoniteurController(IMoniteurInterface moniteurService) {
        this.moniteurService = moniteurService;
    }

    @GetMapping("/all")
    public List<Moniteur> getAllMoniteurs() {
        return moniteurService.retriveAll();
    }

    @PostMapping("/add")
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.addMoniteur(moniteur);
    }

    @PutMapping("/update")
    public Moniteur updateMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.updateMoniteur(moniteur);
    }

    @GetMapping("/{id}")
    public Moniteur getMoniteur(@PathVariable Long id) {
        return moniteurService.retrieveMoniteur(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMoniteur(@PathVariable Long id) {
        moniteurService.deleteMoniteur(id);
    }

    @PostMapping("/add-course/{numCourse}")
    public Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur,
                                                   @PathVariable Long numCourse) {
        return moniteurService.addInstructorAndAssignToCourse(moniteur, numCourse);
    }

    @GetMapping("/{numInstructor}/weeks")
    public List<Integer> getWeeksOfInstructorBySupport(@PathVariable Long numInstructor,
                                                       @RequestParam Support support) {
        return moniteurService.numWeeksCourseOfInstructorBySupport(numInstructor, support);
    }
}
