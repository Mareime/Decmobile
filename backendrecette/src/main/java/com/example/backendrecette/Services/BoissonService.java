package com.example.backendrecette.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendrecette.Models.Boisson;
import com.example.backendrecette.Repository.BoissonRepository;

@Service
public class BoissonService {

    @Autowired
    private BoissonRepository boissonRepository;

    // Récupérer toutes les boissons
    public List<Boisson> getAllBoissons() {
        return boissonRepository.findAll();
    }

    // Récupérer une boisson par son ID
    public Optional<Boisson> getBoissonById(Long id) {
        return boissonRepository.findById(id);
    }

    // Créer une nouvelle boisson
    public Boisson createBoisson(Boisson boisson) {
        return boissonRepository.save(boisson);
    }

    // Mettre à jour une boisson existante
    public Boisson updateBoisson(Long id, Boisson updatedBoisson) {
        return boissonRepository.findById(id)
                .map(boisson -> {
                    boisson.setNom(updatedBoisson.getNom());

                    boisson.setPreparation(updatedBoisson.getPreparation());
                    boisson.setTempsPreparation(updatedBoisson.getTempsPreparation());
                    boisson.setPreferer(updatedBoisson.isPreferer());
                    boisson.setIngredients(updatedBoisson.getIngredients());
                    boisson.setImageUrl(updatedBoisson.getImageUrl());
                    return boissonRepository.save(boisson);
                })
                .orElseThrow(() -> new RuntimeException("Boisson avec ID " + id + " non trouvée"));
    }

    // Supprimer une boisson
    public void deleteBoisson(Long id) {
        boissonRepository.deleteById(id);
    }

    public Boisson findById(Long id) {
        Optional<Boisson> boisson = boissonRepository.findById(id);
        if (boisson.isPresent()) {
            return boisson.get();
        }
        return null;
    }
}
