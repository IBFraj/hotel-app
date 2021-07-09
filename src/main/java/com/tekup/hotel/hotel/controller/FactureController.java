package com.tekup.hotel.hotel.controller;


import com.tekup.hotel.hotel.model.Facture;

import com.tekup.hotel.hotel.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class FactureController {
    @Autowired
    private FactureService factureService;

    @GetMapping("/facture")
    public ResponseEntity<List<Facture>> findall(){
        List<Facture> list = factureService.findAll();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(list);
    }
    @PostMapping("/createFa")
    public ResponseEntity <Facture> save(@RequestBody Facture f) {

        Facture facture = factureService.save(f);
        if (facture == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.created(null).body(facture);
    }
    @PutMapping("updateFa/{idFacture}")
    public Facture modifierFacture(@PathVariable("idFacture") Long id, @RequestBody Facture newFacture) {
        return factureService.modifierFacture(id, newFacture);
    }

    @DeleteMapping("deleteFa/{idFacture}")
    public Facture deleteById(@PathVariable("idFacture") Long id) {
        return factureService.deleteFactureById(id);

    }

}
