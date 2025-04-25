package com.example.backendrecette.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;

    // Enum pour le type de cible
    private CibleType typeCible;

    // L’ID de la recette ou boisson concernée
    private Long idCible;

    public Commentaire() {
    }

    public Commentaire(String contenu, CibleType typeCible, Long idCible) {
        this.contenu = contenu;
        this.typeCible = typeCible;
        this.idCible = idCible;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public CibleType getTypeCible() {
        return typeCible;
    }

    public void setTypeCible(CibleType typeCible) {
        this.typeCible = typeCible;
    }

    public Long getIdCible() {
        return idCible;
    }

    public void setIdCible(Long idCible) {
        this.idCible = idCible;
    }

    // Méthodes pour vérifier la cible
    public boolean isForRecette() {
        return this.typeCible == CibleType.RECETTE;
    }

    public boolean isForBoisson() {
        return this.typeCible == CibleType.BOISSON;
    }

    // Enum pour les types cibles (Recette ou Boisson)
    public enum CibleType {
        RECETTE,
        BOISSON
    }
}
