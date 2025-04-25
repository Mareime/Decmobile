package com.example.backendrecette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backendrecette.Models.Recette;

public interface RecetteRepository extends JpaRepository<Recette, Long> {
    
}
