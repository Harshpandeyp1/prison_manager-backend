package com.prisonmanager.React.controller;

import com.prisonmanager.React.Entity.Inmate;
import com.prisonmanager.React.service.service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/api/inmates")
public class Controller {



    @Autowired
    private service service;

    @PostMapping
    public Inmate create(@RequestBody Inmate inmate) {

        if (inmate.getName() == null || inmate.getName().isEmpty()) {
            throw new RuntimeException("Name is required");
        }

        return service.save(inmate);
    }

    @GetMapping
    public List<Inmate> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/release")
    public Inmate release(@PathVariable Long id) {
        return service.releaseInmate(id);
    }
}


