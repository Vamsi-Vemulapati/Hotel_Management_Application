package com.example.HotelManagement.Repository;

import com.example.HotelManagement.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

    @Query("SELECT g.rating FROM Hotel g  WHERE g.name = :name")
    float getrating(@Param("name") String name);
}
