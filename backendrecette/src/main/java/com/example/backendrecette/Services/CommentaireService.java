package com.example.backendrecette.Services;

import com.example.backendrecette.Models.Commentaire;
import com.example.backendrecette.Repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService {

    private final CommentaireRepository commentaireRepository;

    @Autowired
    public CommentaireService(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }

    // Créer un commentaire
    public Commentaire createCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    // Récupérer un commentaire par son ID
    public Optional<Commentaire> getCommentaireById(Long id) {
        return commentaireRepository.findById(id);
    }

    // Récupérer tous les commentaires
    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

    // Récupérer les commentaires par type (recette ou boisson)
    public List<Commentaire> getCommentairesByType(String typeCible) {
        return commentaireRepository.findAll().stream()
                .filter(commentaire -> commentaire.getTypeCible().name().equalsIgnoreCase(typeCible))
                .toList();
    }

    // Supprimer un commentaire
    public void deleteCommentaire(Long id) {
        commentaireRepository.deleteById(id);
    }
}
