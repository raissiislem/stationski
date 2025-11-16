package tn.esprit.stationski.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Inscription;
import tn.esprit.stationski.services.interfaces.IInscriptionInterface;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionController {

    private final IInscriptionInterface inscriptionService;

    public InscriptionController(IInscriptionInterface inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @PostMapping("/add/skieur/{numSkieur}")
    public Inscription addRegistrationToSkier(@RequestBody Inscription inscription,
                                              @PathVariable Long numSkieur) {
        return inscriptionService.addRegistrationAndAssignToSkier(inscription, numSkieur);
    }

    @PostMapping("/assign-course/{numRegistration}/{numCourse}")
    public Inscription assignRegistrationToCourse(@PathVariable Long numRegistration,
                                                  @PathVariable Long numCourse) {
        return inscriptionService.assignRegistrationToCourse(numRegistration, numCourse);
    }

    @PostMapping("/add/skieur-course/{numSkieur}/{numCours}")
    public Inscription addRegistrationToSkierAndCourse(@RequestBody Inscription inscription,
                                                       @PathVariable Long numSkieur,
                                                       @PathVariable Long numCours) {
        return inscriptionService.addRegistrationAndAssignToSkierAndCourse(inscription, numSkieur, numCours);
    }
}
