package com.example.HotelManagement.Controller;

import com.example.HotelManagement.DTO.HotelDto;
import com.example.HotelManagement.DTO.UpdateHotelAddressDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Service.HotelService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {


    @Autowired
    HotelService hotelService;

    @PostMapping("/createhotel")
    public Hotel CreateHotel(@RequestBody HotelDto hotelDto){
        return hotelService.saveHotel(hotelDto);
    }

    @GetMapping("/getallhotels")
    public  List<Hotel>  GetAllHotels(){
            return hotelService.getallhotels();
    }

    @GetMapping("/gethotelbyid/{id}")
    public Hotel GetHotelById(@PathVariable long id){
        return hotelService.getHotel(id);
    }

    @PutMapping("/updatehotel/{id}")
    public Hotel UpdateHotel(@RequestBody HotelDto hotelDto, @PathVariable long id){
        return hotelService.updatehotel(hotelDto,id);
    }

    @DeleteMapping("/delete/{id}")
    public void  DeleteHotel(@PathVariable long id){
         hotelService.GetHotelByid(id);
    }

    @PutMapping("/hoteladdress/{id}")
    public Hotel UpdateAddress(@RequestBody UpdateHotelAddressDTO hoteladdress, @PathVariable long id){
            return hotelService.updatehoteladdress(hoteladdress,id);
    }

    @GetMapping("/getrating/{name}")
    public float GetRating(@PathVariable String name){
        return hotelService.FindRating(name);
    }
}
