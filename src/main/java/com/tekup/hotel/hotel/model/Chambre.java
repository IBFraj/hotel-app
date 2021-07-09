package com.tekup.hotel.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Chambre {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String numero;
    @Column
    private Long size;
    @Column
    private Long lits;
    @Column
    private int coutParNuit;
    @Column
    private String etat;
    @OneToMany(mappedBy = "chambre")
    @JsonIgnore
    private List<Reservation> reservations;
    @ManyToOne
    private Categorie categorie;

    public Chambre() {

    }

    public Chambre(Long id, String numero, Long size, Long lits, int coutParNuit, String etat, List<Reservation> reservations, Categorie categorie) {
        this.id = id;
        this.numero = numero;
        this.size = size;
        this.lits = lits;
        this.coutParNuit = coutParNuit;
        this.etat = etat;
        this.reservations = reservations;
        this.categorie = categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getLits() {
        return lits;
    }

    public void setLits(Long lits) {
        this.lits = lits;
    }

    public int getCoutParNuit() {
        return coutParNuit;
    }

    public void setCoutParNuit(int coutParNuit) {
        this.coutParNuit = coutParNuit;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
