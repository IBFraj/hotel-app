package com.tekup.hotel.hotel.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Facture {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private LocalDate date_facture;
    @Column
    private float montant;
    @Column
    private String type_paiement;
    @OneToOne(mappedBy = "factures")
    private Client client;

    public Facture() {

    }

    public Facture(Long id, LocalDate date_facture, float montant, String type_paiement) {
        this.id = id;
        this.date_facture = date_facture;
        this.montant = montant;
        this.type_paiement = type_paiement;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate_facture() {
        return date_facture;
    }

    public void setDate_facture(LocalDate date_facture) {
        this.date_facture = date_facture;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getType_paiement() {
        return type_paiement;
    }

    public void setType_paiement(String type_paiement) {
        this.type_paiement = type_paiement;
    }



}
