package com.example.VetClinicSystem.controller;

import com.example.VetClinicSystem.model.Visit;
import com.example.VetClinicSystem.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitController {

    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("")
    public List<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    @GetMapping("/{id}")
    public Visit getVisitById(@PathVariable Long id) {
        return visitService.getVisitById(id)
                .orElseThrow(() -> new IllegalStateException("Visit with id " + id + " does not exist"));
    }

    @PostMapping("")
    public Visit addVisit(@RequestBody Visit visit) {
        return visitService.addVisit(visit);
    }

    @PutMapping("")
    public Visit updateVisit(@RequestBody Visit visit) {
        return visitService.updateVisit(visit);
    }

    @DeleteMapping("/{id}")
    public void deleteVisit(@PathVariable Long id) {
        visitService.deleteVisit(id);
    }

}
