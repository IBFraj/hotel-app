package com.tekup.hotel.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long  id;
    @Column
    private LocalDate DateIn;
    @Column
    private LocalDate DateOut;

    @ManyToOne
    private Client client;
    @ManyToOne
    private Chambre chambre;



    public Reservation() {

    }

    public Reservation(Long id, LocalDate dateIn, LocalDate dateOut, Client client, Chambre chambre) {
        this.id = id;
        DateIn = dateIn;
        DateOut = dateOut;
        this.client = client;
        this.chambre = chambre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateIn() {
        return DateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        DateIn = dateIn;
    }

    public LocalDate getDateOut() {
        return DateOut;
    }

    public void setDateOut(LocalDate dateOut) {
        DateOut = dateOut;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }
}
