package com.tekup.hotel.hotel.service;


import com.tekup.hotel.hotel.model.Hotelier;
import com.tekup.hotel.hotel.repository.HotelierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class HotelierService {
    @Autowired
    private HotelierRepository repository;
    public Hotelier save(Hotelier hotelier){ return repository.save(hotelier);}
    public List<Hotelier> findAll(){ return repository.findAll();}
    public Hotelier getHotelierById(Long id) {
        Optional<Hotelier> opt= repository.findById(id);
        Hotelier entity;
        if(opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Hotelier avec cet identifiant est introuvable");
        return entity;
    }

    public Hotelier modifierHotelier(Long id, Hotelier newentity) {
        Hotelier entity = this.getHotelierById(id);
        if (newentity.getNom() != null)
            newentity.setNom(newentity.getNom());
        if (newentity.getLogin() != null)
            entity.setLogin(newentity.getLogin());
        if (newentity.getMot_de_passe() != null)
            entity.setMot_de_passe(newentity.getMot_de_passe());

        return repository.save(entity);
    }

    public Hotelier deleteHotelierById(Long id) {
        Hotelier	entity = this.getHotelierById(id);
        repository.deleteById(id);
        return entity;
    }
}
