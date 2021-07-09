package com.tekup.hotel.hotel.controller;

import com.tekup.hotel.hotel.model.Admin;

import com.tekup.hotel.hotel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public ResponseEntity<List<Admin>> findall(){
        List<Admin> list = adminService.findAll();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(list);
    }
    @PostMapping("/createAdm")
    public ResponseEntity <Admin> save(@RequestBody Admin a) {

        Admin admin = adminService.save(a);
        if (admin == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.created(null).body(admin);
    }
    @PutMapping("updateAd/{idAdmin}")
    public Admin modifierAdmin(@PathVariable("idAdmin") Long id, @RequestBody Admin newAdmin) {
        return adminService.modifierAdmin(id, newAdmin);
    }

    @DeleteMapping("deleteAd/{idAdmin}")
    public Admin deleteById(@PathVariable("idAdmin") Long id) {
        return adminService.deleteAdminById(id);

    }


}
