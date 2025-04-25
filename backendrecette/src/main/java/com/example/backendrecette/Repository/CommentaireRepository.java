package com.example.backendrecette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendrecette.Models.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    // Méthodes supplémentaires personnalisées peuvent être ajoutées ici
}
