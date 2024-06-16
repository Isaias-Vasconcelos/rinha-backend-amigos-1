package com.rinha.backend_amigos.rinha.backend.repository;

import com.rinha.backend_amigos.rinha.backend.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesRepository extends JpaRepository<Clothes, String> {
}
