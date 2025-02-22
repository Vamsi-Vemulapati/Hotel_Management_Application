package com.example.HotelManagement.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class HotelDto {

    private String name;
    private String address;
    private String city;
    private int postalCode;
    private float rating;
    private boolean isAvailable;
}
