package com.tekup.hotel.hotel.controller;

import com.tekup.hotel.hotel.model.Client;
import com.tekup.hotel.hotel.model.Facture;
import com.tekup.hotel.hotel.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;

@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @GetMapping("/client")
    public ResponseEntity<List<Client>> findall(){
        List<Client> list = clientService.findAll();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(list);
    }
    @GetMapping("/facture/{idClient}")
    public Facture getFact(@PathVariable("idClient") Long id){
        return clientService.getFacture(id);
    }
    @PostMapping("/createCl")
    public ResponseEntity <Client> save(@RequestBody Client c) throws ParseException {
    	   LocalDate localDate = LocalDate.parse(c.getDateDeNaissance().toString());
           //convert String to LocalDate
          // LocalDate localDate = LocalDate.parse(c.getDateDeNaissance().toString(), formatter);
           c.setDateDeNaissance(localDate);
           c.setMot_de_passe(passwordEncoder.encode(c.getMot_de_passe()));
        Client client = clientService.save(c);
        if (client == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.created(null).body(client);
    }
    @PutMapping("updateCl/{idClient}")
    public Client modifierClient(@PathVariable("idClient") Long id, @RequestBody Client newClient) {
        return clientService.modifierClient(id, newClient);
    }

    @DeleteMapping("deleteCl/{idClient}")
    public Client deleteById(@PathVariable("idClient") Long id) {
        return clientService.deleteClientById(id);
    }

}
