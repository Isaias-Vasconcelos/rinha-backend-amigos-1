package com.rinha.backend_amigos.rinha.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;

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

    public String getLastname() {
        return lastname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setClothesToTry(List<Clothes> clothesToTry) {
        this.clothesToTry = clothesToTry;
    }

    public List<Clothes> getClothesToTry() {
        return clothesToTry;
    }
}
