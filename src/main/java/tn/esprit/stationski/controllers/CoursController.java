package tn.esprit.stationski.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.services.interfaces.ICoursInterface;

import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CoursController {

    private final ICoursInterface coursService;

    public CoursController(ICoursInterface coursService) {
        this.coursService = coursService;
    }

    @PostMapping("/add")
    public Cours addCours(@RequestBody Cours cours) {
        return coursService.addCours(cours);
    }

    @PutMapping("/update")
    public Cours updateCours(@RequestBody Cours cours) {
        return coursService.updateCours(cours);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCours(@PathVariable Long id) {
        coursService.deleteCours(id);
    }

    @GetMapping("/all")
    public List<Cours> getAllCours() {
        return coursService.retriveAll();
    }

    @GetMapping("/{id}")
    public Cours getCours(@PathVariable Long id) {
        return coursService.retrieveCours(id);
    }
}
