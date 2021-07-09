package com.tekup.hotel.hotel.service;


import com.tekup.hotel.hotel.model.Client;

import com.tekup.hotel.hotel.model.Facture;
import com.tekup.hotel.hotel.model.Reservation;
import com.tekup.hotel.hotel.repository.ClientRepository;
import com.tekup.hotel.hotel.repository.FactureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private FactureRepository factRepos;
    public Client save(Client client){ return repository.save(client);}
    public List<Client> findAll(){ return repository.findAll();}
    public Client getClientById(Long id) {
        Optional<Client> opt= repository.findById(id);
        Client entity;
        if(opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Client avec cet identifiant est introuvable");
        return entity;
    }



    public Client modifierClient(Long id, Client newentity) {
        Client entity = this.getClientById(id);
        if (newentity.getNom() != null)
            entity.setNom(newentity.getNom());
        if (newentity.getPrenom() != null)
            entity.setPrenom(newentity.getPrenom());
        if (newentity.getCourriel() != null)
            entity.setCourriel(newentity.getCourriel());
        if (newentity.getTelephone() != null)
            entity.setTelephone(newentity.getTelephone());
        if (newentity.getDateDeNaissance() != null)
            entity.setDateDeNaissance(newentity.getDateDeNaissance());
        if (newentity.getEnfant() != null)
            entity.setEnfant(newentity.getEnfant());
        return repository.save(entity);
    }

    public Client deleteClientById(Long id) {
        Client	entity = this.getClientById(id);
        repository.deleteById(id);
        return entity;
    }
    public Facture getFacture(Long id){
        Client client = repository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("client not exist"));
       float montant = 0;
       List <Reservation> r = client.getReservations();
       for (int i =0; i<r.size(); i++){
           montant = montant + r.get(i).getChambre().getCoutParNuit();
       }
       client.getFactures().setMontant(montant);
        factRepos.save(client.getFactures());


        return client.getFactures();
    }

	public boolean existsByCourrier(String c) {
		Client user = repository.findByCourriel(c); //add test 2 to test br
		if (user != null) {
			return true;
		}
		return false;
	}

}
