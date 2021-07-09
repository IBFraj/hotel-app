package com.tekup.hotel.hotel.repository;
import com.tekup.hotel.hotel.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository <Admin,Long>{

}
