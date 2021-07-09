package com.tekup.hotel.hotel.controller;

import com.tekup.hotel.hotel.model.Admin;
import com.tekup.hotel.hotel.model.Chambre;
import com.tekup.hotel.hotel.service.AdminService;
import com.tekup.hotel.hotel.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class ChambreController {
    @Autowired
    private ChambreService chambreService;

    @GetMapping("/chambre")
    public ResponseEntity<List<Chambre>> findall(){
        List<Chambre> list = chambreService.findAll();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(list);
    }
    @PostMapping("/createCh")
    public ResponseEntity <Chambre> save(@RequestBody Chambre c) {

        Chambre chambre = chambreService.save(c);
        if (chambre == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.created(null).body(chambre);
    }
    @PutMapping("updateCh/{idChambre}")
    public Chambre modifierChambre(@PathVariable("idChambre") Long id, @RequestBody Chambre newChambre) {
        return chambreService.modifierChambre(id, newChambre);
    }


    @DeleteMapping("deleteCh/{idChambre}")
    public Chambre deleteById(@PathVariable("idChambre") Long id) {
        return chambreService.deleteChambreById(id);

    }

}
