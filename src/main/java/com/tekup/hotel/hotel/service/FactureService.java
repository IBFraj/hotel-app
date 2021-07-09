package com.tekup.hotel.hotel.service;


import com.tekup.hotel.hotel.model.Facture;

import com.tekup.hotel.hotel.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class FactureService  {
    @Autowired
    private FactureRepository repository;
    public Facture save(Facture facture){ return repository.save(facture);}
    public List<Facture> findAll(){ return repository.findAll();}
    public Facture getFactureById(Long id) {
        Optional<Facture> opt= repository.findById(id);
        Facture entity;
        if(opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Facture avec cet identifiant est introuvable");
        return entity;
    }



    public Facture modifierFacture(Long id, Facture newentity) {
        Facture entity = this.getFactureById(id);
        if (newentity.getDate_facture() != null)
            entity.setDate_facture(newentity.getDate_facture());
        if (newentity.getMontant() != 0)
            entity.setMontant(newentity.getMontant());
        if (newentity.getType_paiement() != null)
            entity.setType_paiement(newentity.getType_paiement());

        return repository.save(entity);
    }

    public Facture deleteFactureById(Long id) {
        Facture	entity = this.getFactureById(id);
        repository.deleteById(id);
        return entity;
    }
}
