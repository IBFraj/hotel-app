package com.tekup.hotel.hotel.repository;

import com.tekup.hotel.hotel.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
