package com.example.backendrecette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backendrecette.Models.Boisson;

public interface BoissonRepository extends JpaRepository<Boisson, Long> {
    
}
