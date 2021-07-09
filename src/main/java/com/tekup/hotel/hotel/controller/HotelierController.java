package com.tekup.hotel.hotel.controller;

import com.tekup.hotel.hotel.model.Hotelier;
import com.tekup.hotel.hotel.service.HotelierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class HotelierController {
    @Autowired
    private HotelierService hotelierService;

    @GetMapping("/hotelier")
    public ResponseEntity<List<Hotelier>> findall(){
        List<Hotelier> list = hotelierService.findAll();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(list);
    }
    @PostMapping("/createHo")
    public ResponseEntity <Hotelier> save(@RequestBody Hotelier h) {

        Hotelier hotelier = hotelierService.save(h);
        if (hotelier == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.created(null).body(hotelier);
    }
    @PutMapping("updateHo/{idHotelier}")
    public Hotelier modifierHotelier(@PathVariable("idHotelier") Long id, @RequestBody Hotelier newHotelier) {
        return hotelierService.modifierHotelier(id, newHotelier);
    }

    @DeleteMapping("deleteHo/{idHotelier}")
    public Hotelier deleteById(@PathVariable("idHotelier") Long id) {
        return hotelierService.deleteHotelierById(id);

    }
}

