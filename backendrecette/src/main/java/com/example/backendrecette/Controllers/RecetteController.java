package com.example.backendrecette.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backendrecette.Models.Recette;
import com.example.backendrecette.Services.RecetteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recettes")
@CrossOrigin(origins = "http://localhost:3000")
public class RecetteController {

    @Autowired
    private RecetteService recetteService;

    // Récupérer toutes les recettes
    @GetMapping
    public List<Recette> getAllRecettes() {
        return recetteService.getAllRecettes();
    }

    // Récupérer une recette par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Recette> getRecetteById(@PathVariable Long id) {
        Optional<Recette> recette = recetteService.getRecetteById(id);
        if (recette.isPresent()) {
            return ResponseEntity.ok(recette.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Créer une nouvelle recette
    @PostMapping
    public ResponseEntity<Recette> createRecette(@RequestBody Recette recette) {
        Recette createdRecette = recetteService.createRecette(recette);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecette);
    }

    // Mettre à jour une recette existante
    @PutMapping("/{id}")
    public ResponseEntity<Recette> updateRecette(@PathVariable Long id, @RequestBody Recette updatedRecette) {
        try {
            Recette savedRecette = recetteService.updateRecette(id, updatedRecette);
            return ResponseEntity.ok(savedRecette);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Supprimer une recette
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecette(@PathVariable Long id) {
        boolean isDeleted = recetteService.deleteRecette(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
