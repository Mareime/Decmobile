package com.example.backendrecette.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Boisson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String ingredients;
    private String preparation;
    private int tempsPreparation; // en minutes
    private String imageUrl;
    private boolean preferer = false;
    public Boisson() {}

    public Boisson(String nom, String ingredients, String preparation, int tempsPreparation, String imageUrl) {
        this.nom = nom;
        this.ingredients = ingredients;
        this.preparation = preparation;
        this.tempsPreparation = tempsPreparation;
        this.imageUrl = imageUrl;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    public String getPreparation() { return preparation; }
    public void setPreparation(String preparation) { this.preparation = preparation; }

    public int getTempsPreparation() { return tempsPreparation; }
    public void setTempsPreparation(int tempsPreparation) { this.tempsPreparation = tempsPreparation; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public boolean isPreferer() {
        return preferer;
    }

    public void setPreferer(boolean preferer) {
        this.preferer = preferer;
    }
}
