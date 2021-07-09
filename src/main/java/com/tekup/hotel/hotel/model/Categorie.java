package com.tekup.hotel.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categorie {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String type;
    @Column
    private int nombreChDispo;
    @OneToMany(mappedBy = "categorie")
    @JsonIgnore
    private List<Chambre> chambres;

    public Categorie() {

    }

    public Categorie(Long id, String type, int nombreChDispo, List<Chambre> chambres) {
        this.id = id;
        this.type = type;
        this.nombreChDispo = nombreChDispo;
        this.chambres = chambres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNombreChDispo() {
        return nombreChDispo;
    }

    public void setNombreChDispo(int nombreChDispo) {
        this.nombreChDispo = nombreChDispo;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }
}
