package com.example.backendrecette.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendrecette.Models.Recette;
import com.example.backendrecette.Repository.RecetteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecetteService {

    @Autowired
    private RecetteRepository recetteRepository;

    // Récupérer toutes les recettes
    public List<Recette> getAllRecettes() {
        return recetteRepository.findAll();
    }

    // Récupérer une recette par son ID
    public Optional<Recette> getRecetteById(Long id) {
        return recetteRepository.findById(id);
    }

    // Créer une nouvelle recette
    public Recette createRecette(Recette recette) {
        return recetteRepository.save(recette);
    }

    // Mettre à jour une recette existante
    public Recette updateRecette(Long id, Recette updatedRecette) {
        return recetteRepository.findById(id)
                .map(recette -> {
                    recette.setTitre(updatedRecette.getTitre());
                    recette.setIngredients(updatedRecette.getIngredients());
                    recette.setEtapes(updatedRecette.getEtapes());
                    recette.setDuree(updatedRecette.getDuree());
                    recette.setImageUrl(updatedRecette.getImageUrl());
                    recette.setPreferer(updatedRecette.isPreferer()); // Ajoute si tu utilises ce champ
                    return recetteRepository.save(recette);
                })
                .orElseThrow(() -> new RuntimeException("Recette avec ID " + id + " non trouvée"));
    }

    // Supprimer une recette
    public boolean deleteRecette(Long id) {
        Optional<Recette> recette = recetteRepository.findById(id);
        if (recette.isPresent()) {
            recetteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Recette findById(Long id) {
        Optional<Recette> recette = recetteRepository.findById(id);
        if (recette.isPresent()) {
            return recette.get();
        }
        return null;
    }
}
