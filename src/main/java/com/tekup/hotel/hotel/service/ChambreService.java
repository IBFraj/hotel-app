package com.tekup.hotel.hotel.service;

import com.tekup.hotel.hotel.model.Chambre;

import com.tekup.hotel.hotel.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class ChambreService {
    @Autowired
    private ChambreRepository repository;
    public Chambre save(Chambre chambre){ return repository.save(chambre);}
    public List<Chambre> findAll(){ return repository.findAll();}
    public Chambre getChambreById(Long id) {
        Optional<Chambre> opt= repository.findById(id);
        Chambre entity;
        if(opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Chambre avec cet identifiant est introuvable");
        return entity;
    }
    public Chambre modifierChambre(Long id, Chambre newentity) {
        Chambre entity = this.getChambreById(id);
        if (newentity.getNumero() != null)
            entity.setNumero(newentity.getNumero());
        if (newentity.getSize() != null)
            entity.setSize(newentity.getSize());
        if (newentity.getLits() != null)
            entity.setLits(newentity.getLits());
        if (newentity.getCoutParNuit()!= 0)
            entity.setCoutParNuit(newentity.getCoutParNuit());
        if (newentity.getEtat() != null)
            entity.setEtat(newentity.getEtat());
        if (newentity.getCategorie() != null)
            entity.setCategorie(newentity.getCategorie());
        return repository.save(entity);
    }
    public Chambre reserveChambre(Chambre chreserv){
        chreserv.setEtat("reservée");


     return repository.save(chreserv)  ;
    }

    public Chambre deleteChambreById(Long id) {
        Chambre	entity = this.getChambreById(id);
        repository.deleteById(id);
        return entity;
    }
}
