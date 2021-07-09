package com.tekup.hotel.hotel.controller;


import com.tekup.hotel.hotel.model.Categorie;

import com.tekup.hotel.hotel.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class CategorieController {
    @Autowired
    private CategorieService categorieService ;

    @GetMapping("/categorie")
    public ResponseEntity<List<Categorie>> findall(){
        List<Categorie> list = categorieService.findAll();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(list);
    }
    @PostMapping("/createCat")
    public ResponseEntity <Categorie> save(@RequestBody Categorie c) {

        Categorie categorie = categorieService.save(c);
        if (categorie  == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.created(null).body(categorie );
    }
    /*@PutMapping("update/{idcategorie}")
    public Categorie modifierCategorie(@PathVariable("idCategorie") Long id, @RequestBody Categorie newCategorie) {
        return categorieService.modifierCategorie(id, newCategorie);
    }

    @DeleteMapping("delete/{idAdmin}")
    public Admin deleteById(@PathVariable("idAdmin") Long id) {
        return adminService.deleteAdminById(id);

    }*/
}
