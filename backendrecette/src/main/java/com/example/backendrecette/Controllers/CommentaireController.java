package com.example.backendrecette.Controllers;
import com.example.backendrecette.Services.CommentaireService;
import com.example.backendrecette.Models.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

    private final CommentaireService commentaireService;

    @Autowired
    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }

    // Créer un commentaire
    @PostMapping
    public ResponseEntity<Commentaire> createCommentaire(@RequestBody Commentaire commentaire) {
        Commentaire createdCommentaire = commentaireService.createCommentaire(commentaire);
        return new ResponseEntity<>(createdCommentaire, HttpStatus.CREATED);
    }

    // Récupérer un commentaire par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Long id) {
        Optional<Commentaire> commentaire = commentaireService.getCommentaireById(id);
        return commentaire.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Récupérer tous les commentaires
    @GetMapping
    public List<Commentaire> getAllCommentaires() {
        return commentaireService.getAllCommentaires();
    }

    // Récupérer les commentaires par type (recette ou boisson)
    @GetMapping("/type/{type}")
    public List<Commentaire> getCommentairesByType(@PathVariable String type) {
        return commentaireService.getCommentairesByType(type);
    }

    // Supprimer un commentaire
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable Long id) {
        commentaireService.deleteCommentaire(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
