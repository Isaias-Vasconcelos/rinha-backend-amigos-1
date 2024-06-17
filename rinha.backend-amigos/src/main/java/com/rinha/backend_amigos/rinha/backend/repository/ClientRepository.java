package com.rinha.backend_amigos.rinha.backend.repository;

import com.rinha.backend_amigos.rinha.backend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {

    @Query("SELECT c FROM Client c WHERE c.name LIKE %:termo%" )
    List<Client> findByNameContaining(@Param("termo") String termo);

    Optional<Client> findByName(String name);

    List<Client> findByNameContainingIgnoreCase(String name);
}
