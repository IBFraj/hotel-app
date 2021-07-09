package com.tekup.hotel.hotel.repository;

import com.tekup.hotel.hotel.model.Chambre;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
}
