package com.example.backendrecette.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendrecette.Models.Boisson;
import com.example.backendrecette.Services.BoissonService;

@RestController
@RequestMapping("/api/boissons")
public class BoissonController {

    @Autowired
    private BoissonService boissonService;

    // Récupérer toutes les boissons
    @GetMapping
    public List<Boisson> getAllBoissons() {
        return boissonService.getAllBoissons();
    }

    // Récupérer une boisson par son ID
    @GetMapping("/{id}")
    public Optional<Boisson> getBoissonById(@PathVariable Long id) {
        return boissonService.getBoissonById(id);
    }

    // Créer une nouvelle boisson
    @PostMapping
    public Boisson createBoisson(@RequestBody Boisson boisson) {
        return boissonService.createBoisson(boisson);
    }

    // Mettre à jour une boisson existante
    @PutMapping("/{id}")
    public Boisson updateBoisson(@PathVariable Long id, @RequestBody Boisson boisson) {
        return boissonService.updateBoisson(id, boisson);
    }

    // Supprimer une boisson
    @DeleteMapping("/{id}")
    public void deleteBoisson(@PathVariable Long id) {
        boissonService.deleteBoisson(id);
    }
}
