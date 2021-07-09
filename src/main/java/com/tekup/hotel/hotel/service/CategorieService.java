package com.tekup.hotel.hotel.service;


import com.tekup.hotel.hotel.model.Categorie;

import com.tekup.hotel.hotel.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class CategorieService {
    @Autowired
    private CategorieRepository repository;
    public Categorie save(Categorie categorie){ return repository.save(categorie);}
    public List<Categorie> findAll(){ return repository.findAll();}
    public Categorie getCategorieById(Long id) {
        Optional<Categorie> opt= repository.findById(id);
        Categorie entity;
        if(opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Categorie avec cet identifiant est introuvable");
        return entity;
    }
    public Categorie catreserv(Categorie cat){
        int x = cat.getNombreChDispo() - 1;

        cat.setNombreChDispo(x);
    return repository.save(cat);}
}
