package com.tekup.hotel.hotel.model;

import javax.persistence.*;

@Entity
public class Hotelier {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nom;
    @Column
    private String login;
    @Column
    private String mot_de_passe;

    public Hotelier() {

    }

    public Hotelier(Long id, String nom, String login, String mot_de_passe) {
        this.id = id;
        this.nom = nom;
        this.login = login;
        this.mot_de_passe = mot_de_passe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
}
