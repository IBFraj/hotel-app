package com.tekup.hotel.hotel.repository;

import com.tekup.hotel.hotel.model.Admin;
import com.tekup.hotel.hotel.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
	Client findByCourriel(String courriel);
}
