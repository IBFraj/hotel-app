package com.tekup.hotel.hotel.repository;

import com.tekup.hotel.hotel.model.Hotelier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelierRepository extends JpaRepository<Hotelier,Long> {
}
