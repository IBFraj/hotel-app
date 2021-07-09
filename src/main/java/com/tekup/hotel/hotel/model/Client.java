package com.tekup.hotel.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String courriel;
    @Column
    private String telephone;
    @Column
    private LocalDate dateDeNaissance;
    @Column
    private Long enfant;
    @Column
    @JsonIgnore
    private String mot_de_passe;

    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
    @OneToOne
    private Facture factures;

    public Client() {

    }

    public Client(Long id, String nom, String prenom, String courriel, String telephone,
    		LocalDate dateDeNaissance, Long enfant, String mot_de_passe, List<Reservation> reservations, Facture factures) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.telephone = telephone;
        this.dateDeNaissance = dateDeNaissance;
        this.enfant = enfant;
        this.mot_de_passe = mot_de_passe;
        this.reservations = reservations;
        this.factures = factures;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public Long getEnfant() {
        return enfant;
    }

    public void setEnfant(Long enfant) {
        this.enfant = enfant;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Facture getFactures() {
        return factures;
    }

    public void setFactures(Facture factures) {
        this.factures = factures;
    }
}
