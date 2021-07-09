package com.tekup.hotel.hotel.service;


import com.tekup.hotel.hotel.model.*;

import com.tekup.hotel.hotel.repository.CategorieRepository;
import com.tekup.hotel.hotel.repository.ChambreRepository;
import com.tekup.hotel.hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;
    @Autowired
    private ChambreService chambreService;
    @Autowired
    private ChambreRepository chmbrerepos;
    @Autowired
    private CategorieRepository catRepos;
    @Autowired
    private CategorieService catServ;
    public Reservation save(Reservation reservation){

        chambreService.reserveChambre(reservation.getChambre());
        catServ.catreserv(reservation.getChambre().getCategorie());

        return repository.save(reservation);}

    public List<Reservation> findAll(){ return repository.findAll();}
    public Reservation getReservationById(Long id) {
        Optional<Reservation> opt= repository.findById(id);
        Reservation entity;
        if(opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Reservation avec cet identifiant est introuvable");
        return entity;
    }

    public Reservation modifierReservation(Long id, Reservation newentity) {
        Reservation entity = this.getReservationById(id);
        if (newentity.getClient() != null)
            newentity.setClient(newentity.getClient());
        if (newentity.getChambre() != null)
            entity.setChambre(newentity.getChambre());
        if (newentity.getDateIn() != null)
            entity.setDateIn(newentity.getDateIn());
        if (newentity.getDateOut() != null)
            entity.setDateOut(newentity.getDateOut());

        return repository.save(entity);
    }

    public Reservation deleteReservationById(Long id) {
        Reservation	entity = this.getReservationById(id);
        entity.getChambre().setEtat("disponible");
        int nbCHdispo = entity.getChambre().getCategorie().getNombreChDispo() + 1;
        entity.getChambre().getCategorie().setNombreChDispo(nbCHdispo);
        chmbrerepos.save(entity.getChambre());
        catRepos.save(entity.getChambre().getCategorie());
        repository.deleteById(id);
        return entity;
    }
    public String checkAvailability(long id , LocalDate dateIN, LocalDate dateOut){
        Categorie categorie = catRepos.findById(id)
                .orElseThrow(()-> new NoSuchElementException("categorie with this id is not exist"));

        Long nb = repository.findAll().stream().filter(reservation -> reservation.getChambre().getCategorie().getType().equals(categorie.getType())
                && reservation.getDateOut().isBefore(dateIN) &&reservation.getDateOut().isBefore(dateOut))
        .collect(Collectors.counting());

        if(categorie.getNombreChDispo()>0 || nb > 0){
            return "Available";}

        else
            return "not Available";



    }
}
