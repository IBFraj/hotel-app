package com.tekup.hotel.hotel.controller;


import com.tekup.hotel.hotel.model.Reservation;

import com.tekup.hotel.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservation")
    public ResponseEntity<List<Reservation>> findall(){
        List<Reservation> list = reservationService.findAll();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(list);
    }
    @PostMapping("/createRe")
    public ResponseEntity <Reservation> save(@RequestBody Reservation r) {

        Reservation reservation = reservationService.save(r);
        if (reservation == null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.created(null).body(reservation);
    }
    @PutMapping("updateRe/{idReservation}")
    public Reservation modifierReservation(@PathVariable("idReservation") Long id, @RequestBody Reservation newReservation) {
        return reservationService.modifierReservation(id, newReservation);
    }

    @DeleteMapping("deleteRe/{idHotelier}")
    public Reservation deleteById(@PathVariable("idHotelier") Long id) {
        return reservationService.deleteReservationById(id);

    }
    @GetMapping("check/{idCat}/{dateIn}/{dateOut}")
    public String checkChambre(@PathVariable("idCat") Long id, @PathVariable("dateIn") String dIn,
                               @PathVariable("dateOut") String dOut){
        LocalDate dateIn = LocalDate.parse(dIn);
        LocalDate dateOut = LocalDate.parse(dOut);
        return reservationService.checkAvailability(id,dateIn,dateOut);
    }

}
