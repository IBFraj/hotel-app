package com.tekup.hotel.hotel.service;

import com.tekup.hotel.hotel.model.Admin;
import com.tekup.hotel.hotel.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;
    public Admin save(Admin admin){ return repository.save(admin);}
    public List<Admin> findAll(){ return repository.findAll();}
    public Admin getAdminById(Long id) {
        Optional<Admin> opt= repository.findById(id);
        Admin entity;
        if(opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Admin avec cet identifiant est introuvable");
        return entity;
    }
    public Admin modifierAdmin(Long id, Admin newentity) {
        Admin entity = this.getAdminById(id);
        if (newentity.getLogin() != null)
            entity.setLogin(newentity.getLogin());
        if (newentity.getMot_de_passe() != null)
            entity.setMot_de_passe(newentity.getMot_de_passe());
        if (newentity.getNom() != null)
            entity.setNom(newentity.getNom());
        return repository.save(entity);
    }
    public Admin deleteAdminById(Long id) {
        Admin	entity = this.getAdminById(id);
        repository.deleteById(id);
        return entity;
    }

}
