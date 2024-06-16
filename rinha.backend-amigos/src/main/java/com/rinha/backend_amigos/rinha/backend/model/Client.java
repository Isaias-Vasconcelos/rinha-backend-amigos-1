package com.rinha.backend_amigos.rinha.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clientes")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Clothes> clothesToTry = new ArrayList<>();

    public void addClothes(Clothes clothes) {
        clothesToTry.add(clothes);
        clothes.setClient(this);
    }

    public void removeClothes(Clothes clothes) {
        clothesToTry.remove(clothes);
        clothes.setClient(null);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setClothesToTry(List<Clothes> clothesToTry) {
        this.clothesToTry = clothesToTry;
    }

    public List<Clothes> getClothesToTry() {
        return clothesToTry;
    }
}
